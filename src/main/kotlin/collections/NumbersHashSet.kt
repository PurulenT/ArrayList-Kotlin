package collections

import java.lang.Math.abs

class NumbersHashSet<T> : NumbersMutableSet<T> {

    var elements = arrayOfNulls<Node<T>?>(INITIAL_CAPACITY)

    override var size: Int = 0
        private set

    override fun add(element: T): Boolean {
        if (size > elements.size * LOAD_FACTOR) {
            increaseArray()
        }
        return add(element, elements).also { added ->
            if (added) {
                size++
            }
        }
    }

    fun add(element: T, array: Array<Node<T>?>): Boolean {
        val newElement = Node(element)
        val position = getElementPosition(element, array.size)
        var existedElement = array[position]
        if (existedElement == null) {
            array[position] = newElement
            return true
        } else {
            while (true) {
                if (existedElement?.item == element) {
                    return false
                } else {
                    if (existedElement?.next == null) {
                        existedElement?.next = newElement
                        return true
                    } else {
                        existedElement = existedElement.next
                    }
                }
            }
        }
    }

    override fun set(index: Int, value: T) {
        TODO("Not yet implemented")
    }

    override fun remove(element: T) {
        remove(element, elements)
    }

    fun remove(element: T, array: Array<Node<T>?>) {
        if (!contains(element)) return
        val position = getElementPosition(element, array.size)
        val existingElement = array[position]
        if (existingElement?.item == element) {
            array[position] = existingElement?.next
            size--
            return
        }

        var before: Node<T>? = existingElement
        while (before?.next != null) {
            val removingElement = before.next
            if (removingElement?.item == element) {
                before.next = removingElement?.next
                size--
                return
            } else {
                before = before.next
            }
        }
    }

    override fun clear() {
        elements = arrayOfNulls<Node<T>?>(INITIAL_CAPACITY)
        size = 0
    }

    override fun contains(element: T): Boolean {
        return contains(element, elements)
    }

    fun contains(element: T, array: Array<Node<T>?>): Boolean {
        val position = getElementPosition(element, array.size)
        var existingElement = array[position]
        while (existingElement != null) {
            if (existingElement.item == element) return true
            else {
                existingElement = existingElement.next
            }
        }
        return false
    }

    private fun getElementPosition(element: T, size: Int): Int {
        return abs(element.hashCode() % size)
    }


    private fun increaseArray() {
        val newArray = arrayOfNulls<Node<T>>(elements.size * 2)
        for (node in elements) {
            var currentElement = node
            while (currentElement != null) { //ошибка в первом коммите: здесь должен быть цикл как здесь
                add(currentElement.item, newArray)
                currentElement = currentElement.next
            }
        }
        elements = newArray
    }

    data class Node<T>(
        val item: T,
        var next: Node<T>? = null
    )

    companion object {
        private const val INITIAL_CAPACITY = 16
        private const val LOAD_FACTOR = 0.75
    }
}

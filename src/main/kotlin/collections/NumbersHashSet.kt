package collections

import java.lang.Math.abs

class NumbersHashSet : NumbersMutableSet {

//    var elements = arrayOfNulls<Node?>(INITIAL_CAPACITY)
//
//    override var size: Int = 0
//        private set
//
//    override fun add(number: Int): Boolean {
//        if (size > elements.size * LOAD_FACTOR) {
//            increaseArray()
//        }
//        return add(number, elements).also { added ->
//            if (added) {
//                size++
//            }
//        }
//    }
//
//    fun add(number: Int, array: Array<Node?>): Boolean {
//        val newElement = Node(number)
//        val position = getElementPosition(number, array.size)
//        var existedElement = array[position]
//        if (existedElement == null) {
//            array[position] = newElement
//            return true
//        } else {
//            while (true) {
//                if (existedElement?.item == number) {
//                    return false
//                } else {
//                    if (existedElement?.next == null) {
//                        existedElement?.next = newElement
//                        return true
//                    } else {
//                        existedElement = existedElement.next
//                    }
//                }
//            }
//        }
//    }
//
//    override fun set(index: Int, value: Int) {
//        TODO("Not yet implemented")
//    }
//
//    override fun remove(number: Int) {
//        remove(number, elements)
//    }
//
//    fun remove(number: Int, array: Array<Node?>) {
//        if (!contains(number)) return
//        val position = getElementPosition(number, array.size)
//        val existingElement = array[position]
//        if (existingElement?.item == number) {
//            array[position] = existingElement.next
//            size--
//            return
//        }
//
//        var before: Node? = existingElement
//        while(before?.next != null) {
//            val removingElement = before.next
//            if (removingElement?.item == number) {
//                before.next = removingElement.next
//                size--
//                return
//            } else {
//                before = before.next
//            }
//        }
//
//
//    }
//
//    override fun clear() {
//        elements = arrayOfNulls<Node?>(INITIAL_CAPACITY)
//        size = 0
//    }
//
//    override fun contains(number: Int): Boolean {
//        return contains(number, elements)
//    }
//
//    fun contains(number: Int, array: Array<Node?>): Boolean {
//        val position = getElementPosition(number, array.size)
//        var existingElement = array[position]
//        while (existingElement != null) {
//            if (existingElement.item == number) return true
//            else {
//                existingElement = existingElement.next
//            }
//        }
//        return false
//    }
//
//    private fun getElementPosition(number: Int, size: Int): Int {
//        return abs(number % size)
//    }
//
//
//    private fun increaseArray() {
//        val newArray = arrayOfNulls<Node?>(elements.size * 2)
//        for (node in elements) {
//            var currentElement = node
//            while (currentElement != null) { //ошибка в первом коммите: здесь должен быть цикл как здесь
//                add(currentElement.item, newArray)
//                currentElement = currentElement.next
//            }
//        }
//        elements = newArray
//    }
//
//    data class Node(
//        val item: Int,
//        var next: Node? = null
//    )
//
//    companion object {
//        private const val INITIAL_CAPACITY = 16
//        private const val LOAD_FACTOR = 0.75
//    }


    var elements = arrayOfNulls<Node?>(CAPACITY)

    override var size: Int = 0
        private set

    override fun add(number: Int): Boolean {
        if (elements.size < LOAD_FACTOR) {
            increaseArray()
        }
        return add(number, elements).also { added->
            if(added){
                size++
            }
        }
    }

    fun add(number: Int, array: Array<Node?>): Boolean {
        val newElement = Node(number)
        val position = getElementPosition(number, array)
        var existingElement = array[position]
        if (existingElement == null) {
            array[position] = newElement
            return true
        } else {
            while (true) {
                if (existingElement?.item == number) {
                    return false
                } else {
                    if (existingElement?.next == null) {
                        existingElement?.next = newElement
                        return true
                    }
                    else {
                        existingElement = existingElement.next
                    }

                }
            }
        }
    }

    fun increaseArray() {
        val newArray = arrayOfNulls<Node?>(elements.size * 2)
        for (node in elements) {
            var currentElement = node
            while (currentElement != null) {
                add(currentElement.item, newArray)
                currentElement = currentElement.next
            }
        }
        elements = newArray
    }

    fun getElementPosition(number: Int, array: Array<Node?>): Int {
        return number % array.size
    }

    override fun set(index: Int, value: Int) {
        TODO("Not yet implemented")
    }

    override fun remove(number: Int) {
        if (!contains(number)) return
        val newElement = Node(number)
        val position = getElementPosition(number, elements)
        val existingElement = elements[position]
        if (existingElement?.item == number){
            elements[position] = existingElement.next
            size--
            return
        }
        var before = existingElement
        while(before?.next != null){
            val findingElement = before.next
            if(findingElement?.item == number){
                before.next = findingElement.next
                size--
                return
            }
            else{
                before = before.next
            }
        }
    }

    override fun clear() {
        size = 0
        elements = arrayOfNulls<Node?>(CAPACITY)
    }

    override fun contains(number: Int): Boolean {
        val position = getElementPosition(number, elements)
        var existingElement = elements[position]
        if (existingElement == null) {
            return false
        } else {
            while (existingElement != null) {
                if (existingElement.item == number) {
                    return true
                } else {
                    existingElement = existingElement.next
                }
            }
            return false
        }
    }

    data class Node(
        val item: Int,
        var next: Node? = null
    )

    companion object {
        const val CAPACITY = 16
        const val LOAD_FACTOR = 0.75
    }

}
package collections

class MyHashMap<K, V> : MyMutableMap<K, V> {
    var elements = arrayOfNulls<Node<K, V>?>(INITIAL_CAPACITY)

    override var size: Int = 0
        private set

    override fun put(key: K, value: V): V? {
        if (size > elements.size * LOAD_FACTOR) {
            increaseArray()
        }
        return put(key, value, elements).also { oldValue ->
            if (oldValue == null) {  //приватный метод пут возвращает либо старое значение объекта, которое было заменено и размер массива не увеличился,
                size++               // либо нулл, в таком случае до этого в объекте ничего не было, а при добавлении нового объекта размер увеличивается на 1
            }
        }
    }

    private fun put(key: K, value: V, array: Array<Node<K, V>?>): V? {
        val newElement = Node(key, value)
        val position = getElementPosition(key, array.size)
        var existedElement = array[position]
        if (existedElement == null) {
            array[position] = newElement
            return null
        } else {
            while (true) {
                if (existedElement?.key == key) {
//                    val oldValue = existedElement?.value
//                    existedElement?.value = value
//                    return oldValue
                    return existedElement?.value.also {
                        existedElement?.value = value
                    }
                } else {
                    if (existedElement?.next == null) {
                        existedElement?.next = newElement
                        return null
                    } else {
                        existedElement = existedElement.next
                    }
                }
            }
        }
    }

//    override fun set(index: Int, value: T) {
//        TODO("Not yet implemented")
//    }

    override fun remove(key: K): V? {
        return remove(key, elements)
    }

    fun remove(key: K, array: Array<Node<K, V>?>): V? {
        if (!containsKey(key)) return null
        val position = getElementPosition(key, array.size)
        val existingElement = array[position]
        if (existingElement?.key == key) {
            array[position] = existingElement?.next
            size--
            return existingElement?.value
        }

        var before: Node<K, V>? = existingElement
        while (before?.next != null) {
            val removingElement = before.next
            if (removingElement?.key == key) {
                before.next = removingElement?.next
                size--
                return removingElement?.value
            } else {
                before = before.next
            }
        }
        return null
    }

    override fun clear() {
        elements = arrayOfNulls<Node<K, V>?>(INITIAL_CAPACITY)
        size = 0
    }

//    override fun contains(element: T): Boolean {
//        return contains(element, elements)
//    }

    override fun containsKey(key: K): Boolean{
        return containsKey(key, elements)
    }

    private fun containsKey(key: K, array: Array<Node<K, V>?>): Boolean {
        val position = getElementPosition(key, array.size)
        var existingElement = array[position]
        while (existingElement != null) {
            if (existingElement.key == key) return true
            else {
                existingElement = existingElement.next
            }
        }
        return false
    }

    private fun getElementPosition(key: K, size: Int): Int {
        return Math.abs(key.hashCode() % size)
    }

    private fun increaseArray() {
        val newArray = arrayOfNulls<Node<K, V>>(elements.size * 2)
        for (node in elements) {
            var currentElement = node
            while (currentElement != null) { //ошибка в первом коммите: здесь должен быть цикл как здесь
                put(currentElement.key, currentElement.value, newArray)
                currentElement = currentElement.next
            }
        }
        elements = newArray
    }

    override fun get(key: K): V? {
        val position = getElementPosition(key, elements.size)
        var existingElement = elements[position]
        while (existingElement != null) {
            if (existingElement.key == key) return existingElement.value
            else {
                existingElement = existingElement.next
            }
        }
        return null
    }

    override fun containsValue(value: V): Boolean {
        foreach {
            if(it.value == value) return true
        }
        return false
    }

    override val keys: MyMutableSet<K>
        get() = MyHashSet<K>().apply {
            foreach {
                add(it.key)
            }
        }

    override val values: MyMutableCollection<V>
        get() = MyArrayList<V>().apply {
            foreach {
                add(it.value)
            }
        }

    private inline fun foreach(operator: (Node<K, V>) -> Unit){
        for (node in elements){
            var currentElement = node
            while(currentElement != null){
                operator(currentElement)
                currentElement = currentElement.next
            }
        }
    }

    data class Node<K, V>(
        val key: K,
        var value: V,
        var next: Node<K, V>? = null
    )

    companion object {
        private const val INITIAL_CAPACITY = 16
        private const val LOAD_FACTOR = 0.75
    }
}
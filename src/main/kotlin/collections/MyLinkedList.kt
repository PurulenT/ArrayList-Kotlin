package collections

class MyLinkedList<T> : MyMutableList<T> {

    private var first: Node<T>? = null
    private var last: Node<T>? = null
    private var modCounter = 0

    class Node<T>(
        var prev: Node<T>? = null,
        val item: T,
        var next: Node<T>? = null
    )

    override var size: Int = 0
        private set

    override fun add(element: T): Boolean {
        modCounter++
        val prevLast = last
        last = Node(prevLast, element)
        if(prevLast == null){
            first = last
        } else {
            prevLast.next = last
        }
        size++
        return true
//        if (size == 0) { этот код теперь не нужен
//            val node = Node(number)
//            first = node
//            last = node
//            size++
//            return
//        }
//        val node = Node(number)
//        last?.next = node
//        last = node
//        size++
    }

    override fun add(index: Int, element: T) {
        modCounter++
        checkIndexForAdding(index)
        if(index == size) {
            add(element)
            return
        }
        if (index == 0) {
            val node = Node(null, element, first)
            first?.prev = node
            first = node
            size++
            return
        }
        val before = getNode(index - 1)
//        val after = getNode(index + 1) лучше вызвать before.next так как второй вызов getNode() заставляет программу прогонять второй цикл
        val after = before.next
        val node = Node(before, element, after)
        before.next = node
        after?.prev = node
        size++
    }

    override fun plus(element: T) {
        add(element)
    }

    override fun get(index: Int): T {
        checkIndex(index)
        return getNode(index).item
    }

    private fun getNode(index: Int): Node<T> {
        if (index == 0) {
            return first!!
        }
        if (index == size - 1) {
            return last!!
        }

        if(index < size/2) { //Не помню что это значит( upd если индекс находится в первой половине коллекции то поиск начинается с первого индекса, иначе во второй половине то с последнего индекса))
            var node = first
            repeat(index) {
                //first = first?.next так лучше не писать, тесты не проходили
                node = node?.next
            }
            return node!!
        }
        else{
            var node = last
            repeat(size - index - 1) {
                //first = first?.next так лучше не писать, тесты не проходили
                node = node?.prev
            }
            return node!!
        }
    }

    override fun set(index: Int, value: T) {
        modCounter++
        checkIndex(index)
        add(index, value)
    }

    private fun unlink(node: Node<T>){
        modCounter++
        val before = node.prev
        val after = node.next
        before?.next = after
        after?.prev = before
        if (after == null) {
            last = before
        }
        if (before == null) {
            first = after
        }
        size--
    }

    override fun removeAt(index: Int) {
        modCounter++
        checkIndex(index)
        val node = getNode(index)
        unlink(node)
//        if(index == 0 && size == 1) { с введением предыдущего элемента код сильно упрощается при помощи метода unlink
//            clear()
//            return
//        }
//        if(index == 0) {
//            first = first?.next
//            size--
//            return
//        }
//        val before = getNode(index - 1)
//        val after = before.next?.next
//        before.next = after
//        if(after == null) {
//            last = before
//        }
//        size--
    }

    override fun minus(element: T) {
        remove(element)
    }

    override fun remove(element: T) {
//        if (first?.item == number) { код сильно упрощается
//            removeAt(0)
//            return
//        }
        modCounter++
        var node = first
        repeat(size){
            if(node?.item == element) {
               node?.let { unlink(it) }
                return
            }
            else{
                node = node?.next
            }
        }
    }

    override fun clear() {
        modCounter++
        first = null
        last = null
        size = 0
    }

    override fun iterator(): MutableIterator<T> {
        return object: MutableIterator<T>{
            private val currentMod = modCounter
            private var nextElement = first
            override fun hasNext(): Boolean {
                return nextElement != null //Если равен налл значит дальше объектов нет, если не равен значит дальше объекты есть
            }

            override fun next(): T {
//                val returnElement = nextElement
//                nextElement = nextElement?.next
//                return returnElement as T
                if(currentMod != modCounter) throw ConcurrentModificationException()
                return nextElement?.item!!.also {
                    nextElement = nextElement?.next
                }
            }

            override fun remove() {
                TODO("Not yet implemented")
            }
        }
    }

    override fun contains(element: T): Boolean {
        var node = first
        repeat(size) {
            if(node?.item == element) return true
            else node = node?.next
        }
        return false
    }

    private fun checkIndex(index: Int){
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index: $index, size: $size")
        }
    }

    private fun checkIndexForAdding(index: Int){
        if (index < 0 || index > size) {
            throw IndexOutOfBoundsException("Index: $index, size: $size")
        }
    }
}
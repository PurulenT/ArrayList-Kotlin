package collections

interface MyMutableList<T> {

    val size: Int

    fun add(element: T)

    fun add(index: Int, element: T)

    operator fun plus(element: T)

    operator fun get(index: Int): T //добавление operator позволяет в реализации обращаться к индексам через []
    operator fun set(index: Int, value: T)

    fun removeAt(index: Int)

    operator fun minus(element: T)

    fun remove(element: T)

    fun clear()

    fun contains(element: T): Boolean
}
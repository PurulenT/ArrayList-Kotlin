package collections

interface MyMutableList<T>: MyMutableCollection<T> {

    override val size: Int

    override fun add(element: T): Boolean

    fun add(index: Int, element: T)

    operator fun plus(element: T)

    operator fun get(index: Int): T //добавление operator позволяет в реализации обращаться к индексам через []
    operator fun set(index: Int, value: T)

    fun removeAt(index: Int)

    operator fun minus(element: T)

    override fun remove(element: T)

    override fun clear()

    override fun contains(element: T): Boolean
}
package collections

interface MyMutableSet<T> {

    val size: Int

    fun add(element: T): Boolean

    operator fun set(index: Int, value: T)

    fun remove(element: T)

    fun clear()

    fun contains(element: T): Boolean
}
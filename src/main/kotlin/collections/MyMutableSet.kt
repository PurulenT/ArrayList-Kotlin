package collections

interface MyMutableSet<T>: MyMutableCollection<T> {

    override val size: Int

    override fun add(element: T): Boolean

    operator fun set(index: Int, value: T)

    override fun remove(element: T)

    override fun clear()

    override fun contains(element: T): Boolean


}
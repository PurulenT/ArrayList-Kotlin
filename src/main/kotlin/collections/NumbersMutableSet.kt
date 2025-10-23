package collections

interface NumbersMutableSet {

    val size: Int

    fun add(number: Int): Boolean

    operator fun set(index: Int, value: Int)

    fun remove(number: Int)

    fun clear()

    fun contains(number: Int): Boolean
}
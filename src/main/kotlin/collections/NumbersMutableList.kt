package collections

interface NumbersMutableList {

    val size: Int

    fun add(number: Int)

    fun add(index: Int, number: Int)

    operator fun plus(number: Int)

    operator fun get(index: Int): Int //добавление operator позволяет в реализации обращаться к индексам через []
    operator fun set(index: Int, value: Int)

    fun removeAt(index: Int)

    operator fun minus(number: Int)

    fun remove(number: Int)

    fun clear()

    fun contains(number: Int): Boolean
}
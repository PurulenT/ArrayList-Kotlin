package collections

interface MyList<T>: MyCollection<T> {

    override val size: Int

    operator fun get(index: Int): T //добавление operator позволяет в реализации обращаться к индексам через []

    override fun contains(element: T): Boolean
}
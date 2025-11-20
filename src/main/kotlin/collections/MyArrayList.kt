package collections

import sun.security.ec.point.ProjectivePoint.Mutable

class MyArrayList<T> : MyMutableList<T> {
    var numbers = arrayOfNulls<Any>(INITIAL_CAPACITY)
    var modCounter = 0

    override var size: Int = 0
        private set

    override fun add(element: T): Boolean {
        modCounter++
        growIfNeeded()
        numbers[size] = element
        size++
        return true
    }

    override fun plus(element: T) {
        add(element)
    }

    override fun minus(element: T) {
        remove(element)
    }

    fun growIfNeeded() {
        if(numbers.size == size){
            val newArray = arrayOfNulls<Any>(numbers.size * 2)
            System.arraycopy(numbers, 0, newArray, 0, size)
//            for(index in numbers.indices){ цикл на языке kotlin/java гораздо медленнее метода arraycopy (низкоуровневый С,С++)
//                newArray[index] = numbers[index]
//            }
            numbers = newArray
        }
    }

//    override fun add(index: Int, number: Int) { Неправильная реализация, но по какой то причине проходит тесты
//        growIfNeeded()
//        for(i in size+1 downTo index + 1){
//            numbers[i] = numbers[i + 1]
//        }
//        numbers[index] = number
//        size++
//    }

    override fun add(index: Int, element: T) {
        modCounter++
        checkIndexForAdding(index)
        growIfNeeded()
        System.arraycopy(numbers, index, numbers, index + 1, size - index)
//        for(i in size downTo index + 1){ copyarray делает то же самое но быстрее так как написан на низкоуровневом языке С,С++
//            numbers[i] = numbers[i - 1] //исправлена ошибка: индекс не size а i
//        }
        numbers[index] = element
        size++
    }

    override fun get(index: Int): T {
        checkIndex(index)
        return numbers[index] as T  //ide жалуется на отсутствие проверки является ли объект типом Т, однако в массив при добалвении нового объекта не мохет попасть объ другого типа.
    }

    override fun set(index: Int, value: T) {
        checkIndex(index)
        numbers[index] = value
    }

    override fun removeAt(index: Int) {
        modCounter++
        checkIndex(index)
        System.arraycopy(numbers, index + 1, numbers, index, size - index - 1) // берем все элементы справа от индекса удаляемого и ставим их на место удаляемого
//        for(i in index until size - 1){
//            numbers[i] = numbers[i + 1]
//        }
        size--
        numbers[size] = null
    }

    override fun remove(element: T) {
        modCounter++
        for(i in numbers.indices){
            if(numbers[i] == element){
                removeAt(i)
            }
        }
    }

    override fun clear() {
        modCounter++
        numbers = arrayOfNulls(INITIAL_CAPACITY)
        size = 0
    }

    override fun iterator(): MutableIterator<T> {
        return object : MutableIterator<T>{
            private val currentMod = modCounter
            private var nextIndex = 0
            override fun hasNext(): Boolean {
                return nextIndex < size
            }

            override fun next(): T {
                if(currentMod != modCounter) throw ConcurrentModificationException()
                return numbers[nextIndex++] as T
            }

            override fun remove() {
                TODO("Not yet implemented")
            }
        }
    }

    override fun contains(element: T): Boolean {
        for(i in numbers.indices){
            if(numbers[i] == element) return true
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

    companion object{
        private const val INITIAL_CAPACITY = 10 //понятно за что отвечает число 10
//        const val отличается от val тем, что для него не создается getter под капотом, и тем более нельзя его переопределить
//                в декпомпиляторе видно что везде где используется const val подставляется его значение сразу (10)
//        как в inline func, а не ссылка на переменную, поэтому значение должно быть известно сразу, и оно должно быть примитивным типом
    }
}

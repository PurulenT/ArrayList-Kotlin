package collections

class NumbersArrayList : NumbersMutableList {
    private var numbers = arrayOfNulls<Int>(INITIAL_CAPACITY)

    override var size: Int = 0
        private set

    override fun add(number: Int) {
        growIfNeeded()
        numbers[size] = number
        size++
    }

    override fun plus(number: Int) {
        add(number)
    }

    override fun minus(number: Int) {
        remove(number)
    }

    fun growIfNeeded() {
        if(numbers.size == size){
            val newArray = arrayOfNulls<Int>(numbers.size * 2)
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

    override fun add(index: Int, number: Int) {
        checkIndexForAdding(index)
        growIfNeeded()
        System.arraycopy(numbers, index, numbers, index + 1, size - index)
//        for(i in size downTo index + 1){ copyarray делает то же самое но быстрее так как написан на низкоуровневом языке С,С++
//            numbers[i] = numbers[i - 1] //исправлена ошибка: индекс не size а i
//        }
        numbers[index] = number
        size++
    }

    override fun get(index: Int): Int {
        checkIndex(index)
        return numbers[index]!!
    }

    override fun set(index: Int, value: Int) {
        checkIndex(index)
        numbers[index] = value
    }

    override fun removeAt(index: Int) {
        checkIndex(index)
        System.arraycopy(numbers, index + 1, numbers, index, size - index - 1) // берем все элементы справа от индекса удаляемого и ставим их на место удаляемого
//        for(i in index until size - 1){
//            numbers[i] = numbers[i + 1]
//        }
        size--
        numbers[size] = null
    }

    override fun remove(number: Int) {
        for(i in numbers.indices){
            if(numbers[i] == number){
                removeAt(i)
            }
        }
    }

    override fun clear() {
        numbers = arrayOfNulls(INITIAL_CAPACITY)
        size = 0
    }

    override fun contains(number: Int): Boolean {
        for(i in numbers.indices){
            if(numbers[i] == number) return true
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

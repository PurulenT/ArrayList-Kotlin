package collections

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class NumbersMutableListTest {

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 1 number then size 1`(list: NumbersMutableList) {
        list.add(0)
        assertEquals(1, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 10 number then size 10`(list: NumbersMutableList) {
        repeat(10){
            list.add(it)
        }
        assertEquals(10, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When get 5th element res is correct`(list: NumbersMutableList) {
        repeat(10){
            list.add(it)
        }
        assertEquals(5, list.get(5))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 100th element then size is 100`(list: NumbersMutableList) {
        repeat(100){
            list.add(it)
        }
        assertEquals(100, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When get 50th element res is correct`(list: NumbersMutableList) {
        repeat(100){
            list.add(it)
        }
        assertEquals(50, list.get(50))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When remove 2 element then res is correct`(list: NumbersMutableList) {
        repeat(100){
            list.add(it)
        }
        list.removeAt(2)
        assertEquals(99, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When remove element then index is next`(list: NumbersMutableList) {
        repeat(100){
            list.add(it)
        }
        list.removeAt(50)
        assertEquals(51, list.get(50))
    }

    companion object{
        @JvmStatic
        fun mutableListSource() = listOf(NumbersArrayList())
    }
}
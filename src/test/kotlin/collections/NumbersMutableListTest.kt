package collections

import org.junit.jupiter.api.Assertions.*
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
    fun `When added at 0 then it is first`(list: NumbersMutableList){
        repeat(100) {
            list.add(it)
        }
        list.add(0, 1000)
        assertEquals(1000, list.get(0))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When added at last then it is last`(list: NumbersMutableList){
        repeat(100) {
            list.add(it)
        }
        list.add(99, 1000)
        assertEquals(1000, list.get(99))
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

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When remove value 50 then 51 instead`(list: NumbersMutableList) {
        repeat(100){
            list.add(it)
        }
        list.remove(50)
        assertEquals(51, list.get(50))
    }

//    @ParameterizedTest не работает -> в реализации мы пообещали что get возвращает !!
//    @MethodSource("mutableListSource")
//    fun `When clear 50th is null`(list: NumbersMutableList) {
//        repeat(100){
//            list.add(it)
//        }
//        list.clear()
//        assertEquals(null, list.get(5))
//    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When clear everything is gone`(list: NumbersMutableList) {
        repeat(100){
            list.add(it)
        }
        list.clear()
        assertEquals(0, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When 50 then contains 50`(list: NumbersMutableList) {
        repeat(100){
            list.add(it)
        }
        assertTrue(list.contains(50))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element does not contains then false`(list: NumbersMutableList) {
        repeat(100){
            list.add(it)
        }
        assertFalse(list.contains(100))
    }

    companion object{
        @JvmStatic
        fun mutableListSource() = listOf(NumbersArrayList())
    }
}
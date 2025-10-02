package calc

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource


class CalcTest {
    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 5 add 10 then 15`(calc: Calculator) {
        val result = calc.sum(5, 10)
        val expected = 15
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 50 add 100`(calc: Calculator) {
        val res = calc.sum(50, 100)
        val exp = 150
        assertEquals(exp, res)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 10 minus 5`(calc: Calculator) {
        val res = calc.min(10, 5)
        val exp = 5
        assertEquals(exp, res)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 100 minus 50`(calc: Calculator) {
        val res = calc.min(100, 50)
        val exp = 50
        assertEquals(exp, res)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 5 mul 25 then 125`(calc: Calculator) {
        val res = calc.mul(5, 25)
        val exp = 125
        assertEquals(exp, res)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 16 mul 132 then 2112`(calc: Calculator) {
        val res = calc.mul(16, 132)
        val exp = 2112
        assertEquals(exp, res)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 16 div 8 then 2`(calc: Calculator) {
        val res = calc.div(16.0, 8.0)
        val exp = 2.0
        assertEquals(exp, res)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 154_2 div 12_3 then 12_536585365853`(calc: Calculator) {
        val res = calc.div(154.2, 12.3)
        val exp = 12.536585365853
        assertEquals(exp, res, 0.0001)
    }

    companion object {
        @JvmStatic
        fun calculatorsSource() = listOf(SimpleCalc(), LoggingCalc())
    }
}




//    @Test
//    fun `When divisional numbers`(){
//        var result = 0.0
//        repeat(100){
//            result += 0.01
//        }
//        val expected = 1.0
//        assertEquals(expected, result, 0.0001)
//    }

//}
package calc

import kotlin.math.log

fun main(){
    val calc = SimpleCalc()
    println(calc.sum(5, 10))
    val logCalc = LoggingCalc()
    println(logCalc.mul(5,5))
}
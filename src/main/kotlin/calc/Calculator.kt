package calc

interface Calculator {
    fun sum(a: Int, b: Int): Int

    fun mul(a: Int, b: Int): Int

    fun min(a: Int, b: Int): Int

    fun div(a: Double, b: Double): Double
}
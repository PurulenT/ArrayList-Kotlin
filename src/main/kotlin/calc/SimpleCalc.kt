package calc

class SimpleCalc: Calculator {
    override fun sum(a: Int, b: Int): Int{
        return a + b
    }

    override fun mul(a: Int, b: Int): Int {
        return a * b
    }

    override fun min(a: Int, b: Int): Int{
        return a - b
    }

    override fun div(a: Double, b: Double): Double{
        return a / b
    }
}
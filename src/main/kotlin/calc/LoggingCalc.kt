package calc

class LoggingCalc: Calculator {
    override fun sum(a: Int, b: Int): Int{
        println("Summing ($a, $b). Result ${a+b}")
        return a + b
    }

    override fun mul(a: Int, b: Int): Int {
        println("Multiplying ($a, $b). Result ${a*b}")
        return a * b
    }

    override fun min(a: Int, b: Int): Int{
        println("Subtraction ($a, $b). Result ${a-b}")
        return a - b
    }

    override fun div(a: Double, b: Double): Double{
        println("Dividing ($a, $b). Result ${a/b}")
        return a / b
    }
}
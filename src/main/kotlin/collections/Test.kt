package collections

fun main() {
//    val numbers = mutableListOf<Int>()
//    while(true){
//        val number = readln().toInt()
//        if(number != 0) {
//            numbers.add(number)
//        }
//        else{
//            break
//        }
//    }
//    numbers.forEach(::println)

    val numbers = NumbersHashSet()
    repeat(100){
        numbers.add(it)
    }

    numbers.elements.forEach(::println)

}
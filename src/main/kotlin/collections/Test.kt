package collections

import kotlin.random.Random

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
        numbers.add(Random.nextInt(0, 1000))
    }

    numbers.elements.forEach(::println)

}
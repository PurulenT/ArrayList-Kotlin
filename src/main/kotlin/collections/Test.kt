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

    val numbers = NumbersHashSet<Int>()
    for (i in 1..10) {
        numbers.add(i)
    }

    numbers.add(100)


    numbers.elements.forEach(::println) //
    println("removing 100 number")
    numbers.remove(100)
    numbers.elements.forEach(::println)
}
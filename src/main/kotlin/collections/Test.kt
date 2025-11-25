package collections

import java.util.*
import kotlin.Comparator
import kotlin.random.Random

fun main() {
//    val numbers = mutableListOf<Int>()
//    val numbers = MyArrayList<Int>()
//    while(true){
//        val number = readln().toInt()
//        if(number != 0) {
//            numbers.add(number)
//        }
//        else{
//            break
//        }
//    }
//
//    for(n in numbers){
//        println(n)
//        numbers.add(10) //ошибка у коллекций - при переборе нельзя изменять содержимое коллекции
//    }
//    numbers.forEach(::println)


    //хэш сет
//    val numbers = MyHashSet<Int>()
//    for (i in 1..10) {
//        numbers.add(i)
//    }
//
//    numbers.add(100)
//
//    for(n in numbers){ //тестирование паттерна итератор при помощи перебора
//        println(n)
////        numbers.add(15)
//    }

//    val iterator = numbers.iterator()  //тестирование паттерна итератор при помощи интерфейса итератор
//    while(iterator.hasNext()){
//        val next = iterator.next()
//        println(next)
//    }


//    numbers.elements.forEach(::println) //
//    println("removing 100 number")
//    numbers.remove(100)
//    numbers.elements.forEach(::println)

    //arrayList
//    val numbers = MyArrayList<String>()
//    while(true){
//        val element = readln().toString()
//        if (element != "done"){
//            numbers.add(element)
//        }
//        else break
//    }

//    for(n in numbers){
//        println(n)
//    }
//
//    val iterator = numbers.iterator()
//    while(iterator.hasNext()){
//        val next = iterator.next()
//        println(next)
//    }

//    println(numbers)
//    numbers.numbers.forEach(::println)

    //linked list
//    val numbers = MyLinkedList<Int>()
//    repeat(10) {
//        numbers.add(1)
//    }
//
//    for (n in numbers) {
//        println(n)
//        numbers.add(15)
//}
//
//    val iterator = numbers.iterator()
//    while(iterator.hasNext()){
//        val next = iterator.next()
//        println(next)
//    }

//sorted set of (tree set)
//    val numbers = TreeSet<Item>()
////    val numbers = sortedSetOf<Item>()
//    repeat(100) {
//        numbers.add(Item(Random.nextInt(0, 100)))
//    }
//    for (n in numbers) { //все элементы расположены в порядке возрастания, т.к. сэт tree set хранит в порядке возрастания элементы, которые наследуют comparable
//        println(n)
//    }
//}

//    val numbers = TreeSet<Item>(object : Comparator<Item> { //В данному случае используется кокмпаратор и реализовывать Компарабл к классе Item не обязательно.
//        override fun compare(o1: Item, o2: Item): Int {     // Компаратор - это функциональный интерфейс, реализация метода сравнения передается прямо в аргумент
//            return when {                                   // Можно использовать такой способ в случае если нет доступа к исходному коду класса Item
//                o1.value > o2.value -> 1
//                o1.value < o2.value -> -1
//                else -> 0
//            }
//        }
//    })
//
//    repeat(100) {
//        numbers.add(Item(Random.nextInt(0, 100)))
//    }
//    for (n in numbers) { //все элементы по прежнему расположены в порядке возрастания
//        println(n)
//    }
//
//
//    val numbersLambda = TreeSet<Item> { o1, o2 -> //функциональный интерфейс компаратор был заменен на лямбду
//        when {
//            o1.value > o2.value -> 1
//            o1.value < o2.value -> -1
//            else -> 0
//        }
//    }

    //тестирование MyHashMap<>

    val content = MyHashMap<Int, Int>()
    repeat(10){
        content.put(it, it)
    }

    println("keys:")
    for(key in content.keys){
        println(key)
    }
    println("values:")
    for(value in content.values){
        println(value)
    }
}
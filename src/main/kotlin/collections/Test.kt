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



    //хэш сет
//    val numbers = MyHashSet<Int>()
//    for (i in 1..10) {
//        numbers.add(i)
//    }
//
//    numbers.add(100)
//
//
//    numbers.elements.forEach(::println) //
//    println("removing 100 number")
//    numbers.remove(100)
//    numbers.elements.forEach(::println)

    //arrayList
    val numbers = MyArrayList<String>()
    while(true){
        val element = readln().toString()
        if (element != "done"){
            numbers.add(element)
        }
        else break
    }
    println(numbers)
    numbers.numbers.forEach(::println)

}
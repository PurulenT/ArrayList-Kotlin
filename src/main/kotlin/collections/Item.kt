package collections

data class Item(val value: Int) : Comparable<Item> {
    override fun compareTo(other: Item): Int {
//        if (value > other.value) return 1 //то же самое
//        else if (value < other.value) return -1
//        else return 0
        return when {
            value > other.value -> 1
            value < other.value -> -1
            else -> 0
        }
    }
}
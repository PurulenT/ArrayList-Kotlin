package collections

interface MyMap<K, V> {

    val size: Int

    operator fun get(key: K): V?

    fun containsKey(key: K): Boolean

    fun containsValue(value: V): Boolean

    val keys: MyMutableSet<K> //переписать на MySet<K>

    val values: MyMutableCollection<V>
}
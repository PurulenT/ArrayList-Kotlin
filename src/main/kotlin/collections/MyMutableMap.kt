package collections

interface MyMutableMap<K, V> {

    val size: Int

    fun put(key: K, value: V): V?

    operator fun get(key: K): V?

    fun containsKey(key: K): Boolean

    fun containsValue(value: V): Boolean

    fun remove(key: K): V?

    fun clear()

    val keys: MyMutableSet<K> //переписать на MySet<K>

    val values: MyMutableCollection<V>
}
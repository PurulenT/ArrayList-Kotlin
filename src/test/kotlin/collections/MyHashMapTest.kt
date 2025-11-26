package collections

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MyHashMapTest{
    private val content = MyHashMap<Int, Int>()

    @Test
    fun `when adding put keys size increases`() {
        content.put(1, 1)
        assertEquals(1, content.keys.size)
    }

    @Test
    fun `when adding put values size increases`() {
        content.put(1, 1)
        assertEquals(1, content.values.size)
    }

    @Test
    fun `when put new value in same key old value returns`() {
        content.put(1, 1)
        assertEquals(1, content.put(1, 2))
    }
    @Test
    fun `when removing keys array decreases`() {
        content.put(1, 1)
        content.remove(1)
        assertEquals(0, content.keys.size)
    }

    @Test
    fun `when removing values size decreases`() {
        content.put(1, 1)
        content.remove(1)
        assertEquals(0, content.values.size)
    }

    @Test
    fun `when removing deleted value returns`() {
        content.put(1, 2)
        assertEquals(2, content.remove(1))
    }

    @Test
    fun `when contains key return true`() {
        content.put(2, 2)
        assertTrue(content.containsKey(2))
    }

    @Test
    fun `when doesnt contain key returns false`() {
        content.put(1, 1)
        assertFalse(content.containsKey(3))
    }

    @Test
    fun `when contains value returns true`() {
        content.put(2, 3)
        assertTrue(content.containsValue(3))
    }

    @Test
    fun `when doesnt contain value returns false`() {
        content.put(4, 3)
        assertFalse(content.containsValue(4))
    }

    @Test
    fun `when got key returns value`() {
        content.put(2, 2)
        assertEquals(2, content.get(2))
    }

    @Test
    fun `when got wrong key returns null`() {
        content.put(2, 2)
        assertEquals(null, content.get(3))
    }

    @Test
    fun `when added 100 k keys size is 100`() {
        repeat(100){
            content.put(it, it)
        }
        assertEquals(100, content.keys.size)
    }

    @Test
    fun `when added 100 v values size is 100`() {
        repeat(100){
            content.put(it, it)
        }
        assertEquals(100, content.values.size)
    }

    @Test
    fun `when clear size is 0`() {
        repeat(100){
            content.put(it, it)
        }
        content.clear()
        assertEquals(0, content.size)
    }
}
package collections

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumbersHashSetTest {
    private val numbers = NumbersHashSet()

    @Test
    fun `When added 100 then size 100`() {
        repeat(100) {
            numbers.add(it)
        }
        assertEquals(100, numbers.size)
    }

    @Test
    fun `When added few same elements only one added`() {
        for (i in 1..3) {
            numbers.add(2)
        }
        assertEquals(1, numbers.size)
    }

    @Test
    fun `After adding element add fun returns true`() {
        assertTrue{numbers.add(0)}
    }

    @Test
    fun `After adding element add fun returns false`() {
        numbers.add(0)
        assertFalse{numbers.add(0)}
    }

    @Test
    fun `When contains returns true`(){
        numbers.add(3)
        assertTrue(numbers.contains(3))
    }

    @Test
    fun `When contains returns false`(){
        assertFalse(numbers.contains(3))
    }

    @Test
    fun `When element deleted size decreased`(){
        repeat(10){
            numbers.add(it)
        }
        numbers.remove(8)
        assertEquals(9, numbers.size)
    }

    @Test
    fun `When element deleted array contains element false`(){
        repeat(10){
            numbers.add(it)
        }
        numbers.remove(8)
        assertFalse(numbers.contains(8))
    }

    @Test
    fun `After clearing array size is 0`() {
        repeat(10) {
            numbers.add(it)
        }
        numbers.clear()
        assertEquals(0, numbers.size)
    }

    @Test
    fun `After clearing whole array is absent`() {
        repeat(10) {
            numbers.add(it)
        }
        numbers.clear()
        repeat(10) {
            assertFalse{ numbers.contains(it) }
        }
    }
}
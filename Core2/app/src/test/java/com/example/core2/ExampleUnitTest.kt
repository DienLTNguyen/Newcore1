package com.example.core2


import com.example.core2.Picture.CREATOR.nameChoose
import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testNameChoosing() {
        nameChoose(name = "Flinder") equals "Flinder is chosen!"
    }

    @Test
    fun testEmptyName() {
        nameChoose(name = "") equals ""
    }
}
infix fun Any?.equals(o2: Any?) = assertEquals(this, o2)

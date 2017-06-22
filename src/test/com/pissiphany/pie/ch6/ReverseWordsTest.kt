package com.pissiphany.pie.ch6

import org.junit.Test
import kotlin.test.assertEquals

class ReverseWordsTest {
    private val value = "Do or do not, there is no try."
    private val expected = "try. no is there not, do or Do"

    @Test
    fun reverseWords() {
        val start = System.nanoTime()
        val result = ReverseWords.reverseWords(value)
        val end = System.nanoTime()

        println("reverseWords: ${end - start}")
        assertEquals(expected, result)
    }

    @Test
    fun reverseWords2() {
        val start = System.nanoTime()
        val result = ReverseWords.reverseWords2(value)
        val end = System.nanoTime()

        println("reverseWords2: ${end - start}")
        assertEquals(expected, result)
    }
}
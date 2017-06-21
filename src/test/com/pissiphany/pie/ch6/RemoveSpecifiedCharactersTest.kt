package com.pissiphany.pie.ch6

import org.junit.Test
import kotlin.test.assertEquals

class RemoveSpecifiedCharactersTest {
    private val str = "Battle of the Vowels: Hawaii vs. Grozny"
    private val remove = "aeiou"
    private val expected = "Bttl f th Vwls: Hw vs. Grzny"

    @Test
    fun removeChars() {
        val start = System.nanoTime()
        val result = RemoveSpecifiedCharacters.removeChars(str, remove)
        val end = System.nanoTime()

        println("removeChars:  ${end - start}")
        assertEquals(expected, result)
    }

    @Test
    fun removeChars2() {
        val start = System.nanoTime()
        val result = RemoveSpecifiedCharacters.removeChars2(str, remove)
        val end = System.nanoTime()

        println("removeChars2: ${end - start}")
        assertEquals(expected, result)
    }
}
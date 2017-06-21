package com.pissiphany.pie.ch6

import com.pissiphany.pie.ch6.FindFirstNonrepeatedCharacter as FFNC

import org.junit.Test
import kotlin.test.assertEquals

class FindFirstNonrepeatedCharacterTest {
    @Test
    fun findNonrepeatedCharacter__using_total() {
        assertEquals('o', FFNC.firstNonrepeatedCharacter("total"))
    }

    @Test
    fun findNonrepeatedCharacter__using_teeter() {
        assertEquals('r', FFNC.firstNonrepeatedCharacter("teeter"))
    }

    @Test(expected = Throwable::class)
    fun findNonrepeatedCharacter__all_repeated() {
        FFNC.firstNonrepeatedCharacter("boob")
    }
}
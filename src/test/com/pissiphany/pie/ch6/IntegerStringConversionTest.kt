package com.pissiphany.pie.ch6

import org.junit.Test
import kotlin.test.assertEquals

class IntegerStringConversionTest {
    @Test
    fun toInt__zero() {
        assertEquals(0, IntegerStringConversion.toInt("0"))
    }

    @Test
    fun toInt__positive_small_number() {
        assertEquals(5, IntegerStringConversion.toInt("5"))
    }

    @Test
    fun toInt__positive_medium_number() {
        assertEquals(11, IntegerStringConversion.toInt("11"))
    }

    @Test
    fun toInt__positive_large_number() {
        assertEquals(119, IntegerStringConversion.toInt("119"))
    }

    @Test
    fun toInt__negative_number() {
        assertEquals(-119, IntegerStringConversion.toInt("-119"))
    }

    @Test
    fun toString__zero() {
        assertEquals("0", IntegerStringConversion.toString(0))
    }

    @Test
    fun toString__one() {
        assertEquals("1", IntegerStringConversion.toString(1))
    }

    @Test
    fun toString__negative_one() {
        assertEquals("-1", IntegerStringConversion.toString(-1))
    }

    @Test
    fun toString__medium_number() {
        assertEquals("152", IntegerStringConversion.toString(152))
    }

    @Test
    fun toString__big_number() {
        assertEquals("2147483647", IntegerStringConversion.toString(2_147_483_647))
    }
}
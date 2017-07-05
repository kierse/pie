package com.pissiphany.pie.ch7

import org.junit.Test
import kotlin.system.measureNanoTime
import kotlin.test.assertEquals

class TelephoneWordsTest {
    @Test
    fun getCharKey__first_key() {
        assertEquals('A', TelephoneWords.getCharKey(2, 1))
    }

    @Test
    fun getCharKey__second_key() {
        assertEquals('B', TelephoneWords.getCharKey(2, 2))
    }

    @Test
    fun getCharKey__third_key() {
        assertEquals('C', TelephoneWords.getCharKey(2, 3))
    }

    @Test
    fun getCharKey__six_o() {
        assertEquals('O', TelephoneWords.getCharKey(6, 3))
    }

    @Test
    fun getCharKey__nine_w() {
        assertEquals('W', TelephoneWords.getCharKey(9, 1))
    }

    @Test
    fun getCharKey__one() {
        assertEquals('1', TelephoneWords.getCharKey(1, 2))
    }

    @Test
    fun getCharKey__zero() {
        assertEquals('0', TelephoneWords.getCharKey(0, 3))
    }

    @Test
    fun printWords__too_cool() {
        val time = measureNanoTime {
            TelephoneWords.printWords(intArrayOf(8,6,6,2,6,6,5))
        }
        println(time)
    }

    @Test
    fun printWords__ones_and_zeros() {
        TelephoneWords.printWords(intArrayOf(0,1)) // should only print one word
    }
}
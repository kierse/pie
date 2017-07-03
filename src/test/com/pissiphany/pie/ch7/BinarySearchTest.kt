package com.pissiphany.pie.ch7

import org.junit.Test
import kotlin.test.assertEquals

class BinarySearchTest {
    private val array = intArrayOf(2,3,6,12,14,27,51,61,80,100)

    @Test
    fun indexOf__2() {
        assertEquals(0, BinarySearch.indexOf(array, 2))
    }

    @Test
    fun indexOf__3() {
        assertEquals(1, BinarySearch.indexOf(array, 3))
    }

    @Test
    fun indexOf__6() {
        assertEquals(2, BinarySearch.indexOf(array, 6))
    }

    @Test
    fun indexOf__12() {
        assertEquals(3, BinarySearch.indexOf(array, 12))
    }

    @Test
    fun indexOf__14() {
        assertEquals(4, BinarySearch.indexOf(array, 14))
    }

    @Test
    fun indexOf__27() {
        assertEquals(5, BinarySearch.indexOf(array, 27))
    }
    @Test
    fun indexOf__51() {
        assertEquals(6, BinarySearch.indexOf(array, 51))
    }
    @Test
    fun indexOf__61() {
        assertEquals(7, BinarySearch.indexOf(array, 61))
    }
    @Test
    fun indexOf__80() {
        assertEquals(8, BinarySearch.indexOf(array, 80))
    }

    @Test
    fun indexOf__100() {
        assertEquals(9, BinarySearch.indexOf(array, 100))
    }

    @Test
    fun indexOf__missing_1() {
        assertEquals(-1, BinarySearch.indexOf(array, 85))
    }

    @Test
    fun indexOf__missing_2() {
        assertEquals(-1, BinarySearch.indexOf(array, 1))
    }
}
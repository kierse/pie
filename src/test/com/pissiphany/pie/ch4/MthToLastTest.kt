package com.pissiphany.pie.ch4

import org.junit.Test
import kotlin.test.assertEquals

class MthToLastTest {
    @Test
    fun mThToLast__return_tail_from_single_element_list() {
        val head = Element(1, null)

        val result = mThToLast(head, 0)

        assertEquals(head, result)
    }

    @Test
    fun mThToLast__return_tail_from_double_element_list() {
        val tail = Element(2, null)
        val head = Element(1, tail)

        val result = mThToLast(head, 0)

        assertEquals(tail, result)
    }

    @Test(expected = MissingElement::class)
    fun mThToLast__mth_element_does_not_exist() {
        mThToLast(Element(1, null), 1)
    }

    @Test
    fun mThToLast() {
        val tail = Element(3, null)
        val middle = Element(2, tail)
        val head = Element(1, middle)

        val result = mThToLast(head, 1)

        assertEquals(middle, result)
    }
}
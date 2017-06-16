package com.pissiphany.pie.ch4

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class LinkedListTailPointerTest {
    @Test
    fun insertAfter__new_head_when_list_empty() {
        val list = HeadTail()
        list.insertAfter(null, 1)
        assertNotNull(list.head)
        assertNotNull(list.tail)
        assertEquals(1, list.head?.obj)
    }

    @Test
    fun insertAfter__new_head_when_list_not_empty() {
        val list = HeadTail()
        list.insertAfter(null, 1)
        list.insertAfter(null, 2)
        assertNotNull(list.head)
        assertNotNull(list.tail)
        assertEquals(2, list.head?.obj)
        assertEquals(1, list.tail?.obj)
    }

    @Test(expected = EmptyListException::class)
    fun insertAfter__empty_list() {
        val list = HeadTail()
        list.insertAfter(Element(1, null), 2)
    }

    @Test(expected = EmptyListException::class)
    fun insertAfter__cannot_find_element() {
        val list = HeadTail()
        val element = Element(1, null)
        list.head = element
        list.tail = element
        list.insertAfter(Element(99, null), 2)
    }

    @Test
    fun insertAfter__middle() {
        val list = HeadTail()
        list.insertAfter(null, 1)
        list.insertAfter(null, 2)
        list.insertAfter(list.head, 3)
        assertEquals(3, list.head?.next?.obj)
    }

    @Test
    fun insertAfter__new_tail() {
        val list = HeadTail()
        list.insertAfter(null, 1)
        list.insertAfter(null, 2)
        list.insertAfter(list.tail, 3)
        assertEquals(3, list.tail?.obj)
    }

    @Test(expected = EmptyListException::class)
    fun delete__empty_list() {
        val list = HeadTail()
        list.delete(Element(1, null))
    }

    @Test
    fun delete__remove_head() {
        val list = HeadTail()
        val tail = Element(2, null)
        val head = Element(1, tail)

        list.head = head
        list.tail = tail

        list.delete(head)

        assertEquals(tail, list.head)
        assertEquals(tail, list.tail)
    }

    @Test
    fun delete__remove_only_element() {
        val list = HeadTail()
        val element = Element(1, null)

        list.head = element
        list.tail = element

        list.delete(element)

        assertNull(list.head)
        assertNull(list.tail)
    }

    @Test
    fun delete__remove_tail() {
        val list = HeadTail()
        val tail = Element(2, null)
        val head = Element(1, tail)

        list.head = head
        list.tail = tail

        list.delete(tail)

        assertNull(list.head?.next)
        assertEquals(list.head, list.tail)
    }

    @Test
    fun delete__remove_random_element() {
        val list = HeadTail()
        val tail = Element(3, null)
        val element = Element(2, tail)
        val head = Element(1, element)

        list.head = head
        list.tail = tail

        list.delete(element)

        assertEquals(head, list.head)
        assertEquals(tail, list.tail)
        assertEquals(tail, list.head?.next)
    }

    @Test(expected = EmptyListException::class)
    fun delete__remove_unknown_element() {
        val list = HeadTail()
        val tail = Element(2, null)
        val head = Element(1, tail)
        val element = Element(3, tail)

        list.head = head
        list.tail = tail

        list.delete(element)
    }
}
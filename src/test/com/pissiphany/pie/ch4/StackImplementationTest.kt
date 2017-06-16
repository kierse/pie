package com.pissiphany.pie.ch4

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StackImplementationTest {
    @Test
    fun push() {
        val stack = Stack<String>()
        stack.push("foo")
    }

    @Test(expected = EmptyStackException::class)
    fun pop__empty_stack() {
        Stack<String>().pop()
    }

    @Test
    fun pop__one_element_stack() {
        val stack = Stack<String>()
        stack.push("foo")
        assertEquals("foo", stack.pop())
    }

    @Test
    fun pop__multi_element_stack() {
        val stack = Stack<String>()
        stack.push("foo")
        stack.push("bar")
        assertEquals("bar", stack.pop())
    }

    @Test
    fun isEmpty__when_empty() {
        assertTrue(Stack<String>().isEmpty())
    }

    @Test
    fun isEmpty__with_element() {
        val stack = Stack<String>()
        stack.push("foo")
        assertFalse(stack.isEmpty())
    }
}
package com.pissiphany.pie.ch5

import org.junit.Test
import kotlin.test.assertEquals

class HeightTest {
    @Test
    fun height__no_children() {
        val tree = Node(null, null)
        assertEquals(1, height(tree))
    }

    @Test
    fun height__with_children() {
        val leaf = Node(null, null)
        val d = Node(leaf, leaf)
        val e = Node(leaf, null)
        val c = Node(d, e)
        val a = Node(leaf, c)

        assertEquals(4, height(a))
        assertEquals(4, height2(a))
    }
}
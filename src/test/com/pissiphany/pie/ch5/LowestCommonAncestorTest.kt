package com.pissiphany.pie.ch5

import org.junit.Test
import kotlin.test.assertEquals

class LowestCommonAncestorTest {
    @Test
    fun lowestCommonAncestor__lowest_is_root() {
        val tree = buildTree()
        val lowest = tree.left?.left as IntNode     // 4
        val greatest = tree.right?.right as IntNode // 28

        assertEquals(tree, lowestCommonAncestor(lowest, greatest, tree))
    }

    @Test
    fun lowestCommonAncestor__in_left_branch() {
        val tree = buildTree()
        val expected = tree.left
        val lowest = tree.left?.left as IntNode     // 4
        val greatest = tree.left?.right?.right as IntNode // 14

        assertEquals(expected, lowestCommonAncestor(lowest, greatest, tree))
    }

    @Test
    fun lowestCommonAncestor__in_right_branch() {
        val tree = buildTree()
        val expected = tree.right
        val lowest = tree.right?.left?.right as IntNode   // 24
        val greatest = tree.right?.right as IntNode // 28

        assertEquals(expected, lowestCommonAncestor(lowest, greatest, tree))
    }

    private fun buildTree(): IntNode {
        val n28 = IntNode(28, null, null)
        val n24 = IntNode(24, null, null)
        val n22 = IntNode(22, null, n24)
        val n26 = IntNode(26, n22, n28)

        val n14 = IntNode(14, null, null)
        val n10 = IntNode(10, null, null)
        val n12 = IntNode(12, n10, n14)
        val n4 = IntNode(4, null, null)
        val n8 = IntNode(8, n4, n12)

        return IntNode(20, n8, n26)
    }
}
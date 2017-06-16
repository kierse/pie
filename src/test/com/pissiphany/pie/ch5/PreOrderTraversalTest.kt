package com.pissiphany.pie.ch5

import org.junit.Test

class PreOrderTraversalTest {
    @Test
    fun recursivePrintPreOrder__null_tree() {
        recursivePrintPreOrder(null)
    }

    @Test
    fun recursivePrintPreOrder__single_node_tree() {
        println("recursive single node tree")
        recursivePrintPreOrder(PreOrderNode(100, null, null))
        println()
    }

    @Test
    fun recursivePrintPreOrder__multi_node_tree() {
        println("recursive multi node tree")
        recursivePrintPreOrder(buildTree())
        println()
    }

    @Test
    fun printPreOrder__multi_node_tree() {
        println("multi node tree")
        printPreOrder(buildTree())
        println()
    }

    private fun buildTree(): PreOrderNode {
        val n110 = PreOrderNode(110, null, null)
        val n125 = PreOrderNode(125, n110, null)
        val n175 = PreOrderNode(175, null, null)
        val n150 = PreOrderNode(150, n125, n175)
        val n25 = PreOrderNode(25, null, null)
        val n75 = PreOrderNode(75, null, null)
        val n50 = PreOrderNode(50, n25, n75)
        return PreOrderNode(100, n50, n150)
    }
}
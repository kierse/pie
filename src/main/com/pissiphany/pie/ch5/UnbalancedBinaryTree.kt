package com.pissiphany.pie.ch5

object UnbalancedBinaryTree {
    data class Node(val data: Int, var left: Node?, var right: Node?)

    fun balance(tree: Node) {
        val current = tree
        do {
            val left = current.left

            current.left = left?.right
            left?.right = current

            val balance = depth(current.right) - depth(current.left)
        } while (balance > 1 || balance < -1)
    }

//    private fun depth(node: Node?, depth: Int): Int {
//        if (node == null) return depth
//        return Math.max(depth(node.left, depth + 1), depth(node.right, depth + 1))
//    }

    private fun depth(node: Node?): Int {
        if (node == null) return 0
        return 1 + Math.max(depth(node.left), depth(node.right))
    }
}

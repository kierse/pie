package com.pissiphany.pie.ch5

data class Node(val left: Node?, val right: Node?)

fun height(tree: Node): Int {
    return maxHeight(tree, 1)
}

private fun maxHeight(tree: Node, seed: Int): Int {
    val leftHeight = tree.left?.let { maxHeight(it, seed+1) } ?: 0
    val rightHeight = tree.right?.let { maxHeight(it, seed+1) } ?: 0

    return intArrayOf(leftHeight, rightHeight, seed).max() ?: seed
}

fun height2(tree: Node?): Int {
    if (tree == null) return 0
    return 1 + Math.max(
            height2(tree.left),
            height2(tree.right)
    )
}

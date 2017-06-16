package com.pissiphany.pie.ch5

data class PreOrderNode(val data: Int, val left: PreOrderNode?, val right: PreOrderNode?)

fun recursivePrintPreOrder(tree: PreOrderNode?) {
    if (tree == null) return
    println(tree.data)
    recursivePrintPreOrder(tree.left)
    recursivePrintPreOrder(tree.right)
}

fun printPreOrder(tree: PreOrderNode) {
    val stack = PreOrderNodeStack()
    var current: PreOrderNode? = tree

    while (current != null) {
        println(current.data)

        val left = current.left
        val right = current.right

        if (left == null) {
            current = stack.pop()
        } else {
            current = left
            if (right != null) stack.push(right)
        }
    }
}

class PreOrderNodeStack {
    private val stack = mutableListOf<PreOrderNode>()

    fun push(node: PreOrderNode) {
        stack.add(node)
    }

    fun pop() = if (stack.isEmpty()) null else stack.removeAt(stack.size-1)

    fun peek() = stack.getOrNull(stack.size-1)

    fun hasElements() = stack.isNotEmpty()
}

package com.pissiphany.pie.ch5

data class PreOrderNode(val data: Int, val left: PreOrderNode?, val right: PreOrderNode?)

fun recursivePrintPreOrder(tree: PreOrderNode?) {
    if (tree == null) return
    println(tree.data)
    recursivePrintPreOrder(tree.left)
    recursivePrintPreOrder(tree.right)
}

fun printPreOrder(tree: PreOrderNode) {
    println(tree.data)

    val stack = Stack()
    var current: PreOrderNode? = tree

    while (current != null) {
        val left = current?.left
        val right = current?.right

        if (left == null) {
            current = stack.pop()
            current?.let { println(it.data) }
        } else {
            println(left.data)
            current = left
            if (right != null) stack.push(right)
        }
    }

//    val stack = Stack(StackElement(tree))
//    println(tree.data)
//
//    while (stack.hasElements()) {
//        val element = stack.peek()
//        when {
//            element.left -> {
//                val node = element.node.left
//                if (node == null) {
//                    stack.pop()
//                } else {
//                    element.left = false
//                    println(node.data)
//                    stack.push(StackElement(node))
//                }
//            }
//
//            element.right -> {
//                val node = element.node.right
//                if (node == null) {
//                    stack.pop()
//                } else {
//                    element.right = false
//                    println(node.data)
//                    stack.push(StackElement(node))
//                }
//            }
//
//            else -> stack.pop()
//        }
//    }
}

class Stack {
    private val stack = mutableListOf<PreOrderNode>()

    fun push(node: PreOrderNode) {
        stack.add(node)
    }

    fun pop() = if (stack.isEmpty()) null else stack.removeAt(stack.size-1)

    fun peek() = stack.getOrNull(stack.size-1)

    fun hasElements() = stack.isNotEmpty()
}

//class StackElement(val node: PreOrderNode)


//class Stack(seed: StackElement) {
//    private val stack = mutableListOf(seed)
//
//    fun push(element: StackElement) {
//        stack.add(element)
//    }
//
//    fun pop() = stack.removeAt(stack.size-1)
//
//    fun peek() = stack[stack.size-1]
//
//    fun hasElements() = stack.isNotEmpty()
//}


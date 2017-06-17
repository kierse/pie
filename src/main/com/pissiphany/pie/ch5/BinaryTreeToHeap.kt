package com.pissiphany.pie.ch5

object BinaryTreeToHeap {
    data class IntNode(val data: Int, var left: IntNode?, var right: IntNode?)

    fun buildHeap(unorderedTree: IntNode): IntNode {
        val count = traverse(unorderedTree, 0, null)
        val array = arrayOfNulls<IntNode>(count)
        traverse(unorderedTree, 0, array)

        // Note: can safely do this as the previous line iterated over the tree and populated the array
        // As the array was initialized by a call to the same method / process, we can be confident that
        // the array has been fully populated
        @Suppress("UNCHECKED_CAST")
        array as Array<IntNode>

        array.sortBy { it.data }

        for (i in 0..count-1) {
            val node = array[i]
            node.left = array.getOrNull(2 * i + 1)
            node.right = array.getOrNull(2 * i + 2)
        }

        return array[0]
    }

    private fun traverse(tree: IntNode?, seed: Int, array: Array<IntNode?>?): Int {
        if (tree == null) return seed

        array?.apply { set(seed, tree) }

        var count = seed + 1
        count = traverse(tree.left, count, array)
        count = traverse(tree.right, count, array)

        return count
    }

//private fun traverse(tree: IntNode, array: IntArray?): Int {
//    val stack = IntNodeStack()
//    stack.push(tree)
//
//    var count = 0
//    while (stack.hasElements()) {
//        val node = stack.pop()
//
//        array?.apply { set(count, node.data) }
//
//        node.right?.let { stack.push(it) }
//        node.left?.let { stack.push(it) }
//        count++
//    }
//
//    return count
//}
//
//class IntNodeStack {
//    private val stack = mutableListOf<IntNode>()
//
//    fun push(node: IntNode) {
//        stack.add(node)
//    }
//
//    fun pop() = stack.removeAt(stack.size-1)
//
//    fun hasElements() = stack.isNotEmpty()
//}
}


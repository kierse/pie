package com.pissiphany.pie.ch5

data class IntNode(val data: Int, val left: IntNode?, val right: IntNode?)

fun lowestCommonAncestor(lower: IntNode, greater: IntNode, tree: IntNode): IntNode {
    var current = tree

    while (true) {
        val data = current.data
        if (data > lower.data && data > greater.data) {
            current = current.left!!
        } else if (data < lower.data && data < greater.data) {
            current = current.right!!
        } else {
            break
        }
    }

    return current
}

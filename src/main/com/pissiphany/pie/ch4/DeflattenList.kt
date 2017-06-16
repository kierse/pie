package com.pissiphany.pie.ch4

fun <T> deflatten(head: Node<T>): Node<T> {
    separate(head)

    var current = head
    while (true) {
        current = current.next ?: break
    }

    // new tail value
    return current
}

private fun <T> separate(head: Node<T>) {
    var current = head
    while (true) {
        val child = current.child
        if (child != null) {
            child.prev?.next = null
            child.prev = null
            deflatten(child)
        }

        current = current.next ?: break
    }
}
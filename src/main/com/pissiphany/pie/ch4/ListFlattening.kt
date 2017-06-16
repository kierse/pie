package com.pissiphany.pie.ch4

// best solution
fun <T> flatten(head: Node<T>, tail: Node<T>): Node<T> {
    var current = head
    var currentTail = tail

    while (true) {
        val child = current.child
        if (child != null) {
            currentTail.next = child
            child.prev = currentTail

            currentTail = getTail(child)
        }

        current = current.next ?: break
    }

    // new tail value
    return current
}

//// better solution
//fun <T> inlineFlatten(head: Node<T>) {
//    var current = head
//    while (true) {
//        val child = current.child
//        if (child != null) {
//            val oldNext = current.next
//            val childTail = getTail(child)
//
//            current.next = child
//            child.prev = current
//
//            childTail.next = oldNext
//            oldNext?.prev = childTail
//        }
//
//        current = current.next ?: break
//    }
//}

private fun <T> getTail(head: Node<T>): Node<T> {
    var current = head
    while (true) {
        current = current.next ?: break
    }

    return current
}

//// this works but requires recursion which isn't ideal
//fun <T> recursiveFlatten(head: Node<T>) {
//    recursiveFlattenList(null, head)
//}
//
//private fun <T> recursiveFlattenList(prev: Node<T>?, childHead: Node<T>): Node<T> {
//    prev?.next = childHead
//    prev?.child = null
//    childHead.prev = prev
//
//    var current: Node<T> = childHead
//    while (true) {
//        if (current.child == null) {
//            current = current.next ?: break
//            continue
//        }
//
//        val next = current.next
//        val child = current.child as Node<T>
//
//        current = recursiveFlattenList(current, child)
//
//        current.next = next
//        next?.prev = current
//
//        if (current.next == null) break
//    }
//
//    return current
//}

data class Node<T>(val data: T, var next: Node<T>?, var prev: Node<T>?, var child: Node<T>?)

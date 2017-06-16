package com.pissiphany.pie.ch4

fun mThToLast(head: Element, m: Long): Element {
    if (m == 0L) {
        var current = head
        while (true) {
            current = current.next ?: break
        }

        return current
    }

    var current: Element? = head
    for (i in 1..m) {
        current = current?.next ?: throw MissingElement("mth element from last does not exist!")
    }

    var requested = head
    while (true) {
        current = current?.next ?: break
        requested = head.next as Element
    }

    return requested
}

class MissingElement(msg: String) : Throwable(msg)

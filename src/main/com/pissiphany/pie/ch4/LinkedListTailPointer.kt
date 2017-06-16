package com.pissiphany.pie.ch4

// Ch4: Maintain linked list tail pointer
class HeadTail {
    internal var head: Element? = null
    internal var tail: Element? = null

    fun delete(element: Element) {
        val localHead = head ?: throw EmptyListException("empty list!")

        if (localHead == element) {
            head = localHead.next

            if (head == null) {
                tail = null
            }

            return
        }

        var current = localHead
        while (true) {
            if (current.next == element) {
                current.next = element.next

                if (current.next == null) {
                    tail = current
                }

                return
            }

            current = current.next ?: break
        }

        throw EmptyListException("unable to find given element!")
    }

    fun insertAfter(element: Element?, obj: Int) {
        // new head
        if (element == null) {
            val newElement = Element(obj, head)

            if (head == null) {
                tail = newElement
            }
            head = newElement

            return
        }

        // empty list
        if (head == null) throw EmptyListException("unable to find given element. List empty!")

        // new tail
        // insert in middle
        var current = head
        while (true) {
            if (current == element) {
                val newElement = Element(obj, current.next)
                current.next = newElement

                if (newElement.next == null) {
                    tail = newElement
                }

                return
            }

            current = current?.next ?: break
        }

        throw EmptyListException("unable to find given element!")
    }
}

data class Element(val obj: Int, var next: Element?)
class EmptyListException(msg: String) : Throwable(msg)



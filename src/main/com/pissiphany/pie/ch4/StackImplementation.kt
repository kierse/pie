package com.pissiphany.pie.ch4

// Ch4: Stack Implementation
class Stack<T> {
    private class Element<T>(val obj: T, var next: Element<T>?)

    private var head: Element<T>? = null

    fun push(obj: T) {
        val element = Element(obj, head)
        head = element
    }

    fun pop(): T {
        val currentHead: Element<T> = head ?: throw EmptyStackException("Stack empty! Nothing to pop")
        head = currentHead.next
        return currentHead.obj
    }

    fun isEmpty() = head == null
}
class EmptyStackException(msg: String) : Throwable(msg)

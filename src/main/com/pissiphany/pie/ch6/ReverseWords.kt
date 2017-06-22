package com.pissiphany.pie.ch6

object ReverseWords {
    // 1. use two pointers to reverse string
    // 2. use two pointers to reverse chars found between spaces
    fun reverseWords(value: String): String {
        val array = value.toCharArray()

        reverse(array)

        var start = 0
        var current = 0

        while (current < array.size) {
            if (array[current] == ' ') {
                reverse(array, start, current-1)
                start = current + 1 // move start past the space
            }

            current++
        }

        if (current > start) {
            reverse(array, start, current-1)
        }

        return String(array)
    }

    private fun reverse(array: CharArray, start: Int = 0, end: Int = array.size-1) {
        var front = start
        var back = end

        while (front < back) {
            val temp = array[front]
            array[front] = array[back]
            array[back] = temp

            front++
            back--
        }
    }

    fun reverseWords2(value: String): String {
        val array = CharArray(value.length)

        var current = value.length - 1
        var endOfWord = current
        var p = 0

        while (current > 0) {
            if (value[current] == ' ') {
                p = copy(array, p, value, current+1, endOfWord)
                array[p++] = ' '
                endOfWord = current - 1
            }

            current--
        }

        if (endOfWord > current) {
            copy(array, p, value, current, endOfWord)
        }

        return String(array)
    }

    private fun copy(array: CharArray, copyStart: Int, value: String, start: Int, end: Int): Int {
        var current = copyStart
        for (i in start..end) {
            array[current++] = value[i]
        }

        return current
    }
}
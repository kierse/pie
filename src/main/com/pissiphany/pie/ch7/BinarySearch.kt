package com.pissiphany.pie.ch7

object BinarySearch {
    fun indexOf(sortedArray: IntArray, value: Int): Int {
        return indexOf(sortedArray, value, 0, sortedArray.size - 1)
    }

    private fun indexOf(sortedArray: IntArray, value: Int, min: Int, max: Int): Int {
        if (min == max) {
            return if (sortedArray[min] == value) min
                   else -1
        }

        val middle = (max - min) / 2
        val current = min + middle
        val guess = sortedArray[current]

        if (guess == value) return current
        if (guess > value) return indexOf(sortedArray, value, min, current - 1)
        else return indexOf(sortedArray, value, current + 1, max)
    }
}
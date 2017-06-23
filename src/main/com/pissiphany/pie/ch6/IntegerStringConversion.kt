package com.pissiphany.pie.ch6

object IntegerStringConversion {
    // 1. determine if string starts with negative sign
    // 2. iterate over each char
    //   2a. multiply by 10 for each iteration of the loop
    // 3. add all values to arrive at absolute value (bitwise add)
    // 4. apply applicable sign
    fun toInt(str: String): Int {
        val value = if (str[0] == '-') str.substring(1) else str

        var calculated = 0
        for (char in value) {
            calculated *= 10
            calculated += char.toInt() - '0'.toInt()
        }

        return if (str.length > value.length) -calculated else calculated
    }

    // original attempt
//    fun toInt2(str: String): Int {
//        val value = if (str[0] == '-') str.substring(1) else str
//
//        var i = 0
//        var calculated = 0
//        for (char in value.reversed()) {
//            calculated += multiplyByTen(char.toInt() - '0'.toInt(), i++)
//        }
//
//        return if (str.length > value.length) -1 * calculated else calculated
//    }
//
//    private fun multiplyByTen(seed: Int, times: Int): Int {
//        if (times == 0) return seed
//
//        var calculated = seed
//        (1..times).forEach {
//            calculated = calculated.shl(3) + calculated.shl(1)
//        }
//
//        return calculated
//    }


    fun toString(int: Int): String {
        if (int == 0) return "0"

        val array = IntArray(10) // number of digits in Int.MAX_VALUE (+/-2,147,483,647)

        var progress = if (int < 0) -int else int
        var current = array.size

        while (progress > 0) {
            val remainder = progress % 10
            progress /= 10

            // ASCII digit value
            val digit = remainder + '0'.toInt()
            array[--current] = digit
        }

        val result = String(array, current, array.size - current)
        return if (int < 0) "-$result" else result
    }
}
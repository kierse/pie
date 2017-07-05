package com.pissiphany.pie.ch7

object TelephoneWords {
    fun printWords(array: IntArray) {
        printWords(array, 0, CharArray(array.size))
    }

    private fun printWords(array: IntArray, current: Int, out: CharArray) {
        if (current == array.size) {
            println(String(out))
            return
        }

//        for (i in start..array.size-1) {
//            val num = array[i]
//            val begin = if (num < 2) 3 else 1
//            for (j in begin..3) {
//                out[i] = getCharKey(array[i], j)
//                printWords(array, i+1, out)
//            }
//        }

        for (i in 1..3) {
            out[current] = getCharKey(array[current], i)
            printWords(array, current+1, out)
            if (array[current] < 2) return
        }
    }

//    fun printWords(array: IntArray) {
//        printWords(array, 0, StringBuilder())
//    }
//
//    private fun printWords(array: IntArray, start: Int, out: StringBuilder) {
//        if (out.length == array.size) {
//            println(out.toString())
//            return
//        }
//
//        for (i in start..array.size-1) {
//            val num = array[i]
//            val begin = if (num < 2) 3 else 1
//            for (j in begin..3) {
//                out.append(getCharKey(array[i], j))
//                printWords(array, i+1, out)
//                out.setLength(out.length-1)
//            }
//        }
//    }

    fun getCharKey(telephoneKey: Int, place: Int): Char {
        if (telephoneKey < 2) {
            return if (telephoneKey == 0) '0' else '1'
        }

        val multiplier = telephoneKey - 2
        val qOffset = if (telephoneKey > 6) 1 else 0
        val letterOffset = place - 1

        return (65 + (3 * multiplier) + letterOffset + qOffset).toChar()
    }
}
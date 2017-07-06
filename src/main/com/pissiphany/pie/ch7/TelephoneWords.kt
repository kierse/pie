package com.pissiphany.pie.ch7

object TelephoneWords {
    fun printWordsRecursively(array: IntArray) {
        printWordsRecursively(array, 0, CharArray(array.size))
    }

    private fun printWordsRecursively(array: IntArray, current: Int, out: CharArray) {
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
            printWordsRecursively(array, current+1, out)
            if (array[current] < 2) return
        }
    }

//    fun printWordsRecursively(array: IntArray) {
//        printWords(array, 0, StringBuilder())
//    }
//
//    private fun printWordsRecursively(array: IntArray, start: Int, out: StringBuilder) {
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

    fun printWords(array: IntArray) {
        val out = CharArray(array.size)
        val stack = IntArray(array.size)

        var i = 0
        while (i >= 0) {
            if (stack[i] == 3) {
                stack[i] = 0
                i -= 1
                continue
            }

            // number is a 0 or a 1
            if (array[i] < 2) {
                stack[i] = 3
            } else {
                stack[i] += 1
            }

            out[i] = getCharKey(array[i], stack[i])

            if (i == array.size - 1) {
                println(String(out))
            } else {
                i += 1
            }
        }
    }

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
package com.pissiphany.pie.ch7

object PermutationsOfAString {
    fun printPermutations(str: String) {
        printPermutations(str, 0)
    }

    private fun printPermutations(str: String, start: Int) {
        println(str)

        if (start + 1 == str.length) return

        for (i in start..str.length-1) {
            for (j in i+1..str.length-1) {
                val newStr = swapChars(str, i, j)
                printPermutations(newStr, i + 1)
            }
        }
    }

    private fun swapChars(str: String, a: Int, b: Int): String {
        val array = str.toCharArray()
        val temp = array[a]
        array[a] = array[b]
        array[b] = temp
        return String(array)
    }

//    fun printPermutations(str: String) {
//        printPermutations(str, BooleanArray(str.length), StringBuilder())
//    }
//
//    private fun printPermutations(str: String, used: BooleanArray, out: StringBuilder) {
//        if (out.length == str.length) {
//            println(out.toString())
//            return
//        }
//
//        for (i in 0..str.length-1) {
//            if (used[i]) continue
//            used[i] = true
//            out.append(str[i])
//            printPermutations(str, used, out)
//            used[i] = false
//            out.setLength(out.length - 1)
//        }
//    }
}
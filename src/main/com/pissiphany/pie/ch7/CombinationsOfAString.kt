package com.pissiphany.pie.ch7

object CombinationsOfAString {
    fun combinations(str: String) {
        combinations(str, 0, StringBuilder())
    }

    private fun combinations(str: String, start: Int, out: StringBuilder) {
        for (i in start..str.length-1) {
            out.append(str[i])
            println(out.toString())

            if (i+1 < str.length) {
                combinations(str, i+1, out)
            }

            out.setLength(out.length-1)
        }
    }
}
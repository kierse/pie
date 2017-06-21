package com.pissiphany.pie.ch6

object RemoveSpecifiedCharacters {
    // Note: only dealing with ASCII
    fun removeChars(str: String, remove: String): String {
        val charsToRemove = mutableSetOf<Char>()
        remove.forEach { charsToRemove.add(it) }

        val builder = StringBuilder()
        for (char in str) {
            if (charsToRemove.contains(char)) continue
            builder.append(char)
        }

        return builder.toString()
    }

    fun removeChars2(str: String, remove: String): String {
        val charsToRemove = BooleanArray(128)
        for (char in remove) {
            charsToRemove[char.toInt()] = true
        }

        val strArray = str.toCharArray()

        var read = 0
        var write = 0
        strArray.forEach {
            if (!charsToRemove[it.toInt()]) {
                strArray[write] = it
                write++
            }
            read++
        }

        return String(strArray, 0, write)
    }
}
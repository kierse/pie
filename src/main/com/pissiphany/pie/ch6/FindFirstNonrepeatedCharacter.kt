package com.pissiphany.pie.ch6

object FindFirstNonrepeatedCharacter {
    private enum class Occurrence {
        ONCE, MULTIPLE
    }

    // O(2n) == O(n)
    fun firstNonrepeatedCharacter(value: String): Char {
        val map = mutableMapOf<Char, Occurrence>()

        value.forEach { c ->
            if (map.contains(c)) map[c] = Occurrence.MULTIPLE
            else map[c] = Occurrence.ONCE
        }

        value.forEach { if (map[it] == Occurrence.ONCE) return it }

        throw Throwable("all chars are repeated!")
    }
}
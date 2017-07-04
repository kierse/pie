package com.pissiphany.pie.ch7

import org.junit.Test
import kotlin.system.measureNanoTime

class PermutationsOfAStringTest {
    @Test
    fun oneLetter() {
        // a
        println()
        PermutationsOfAString.printPermutations("a")
    }

    @Test
    fun twoLetter() {
        // ab
        // ba
        println()
        PermutationsOfAString.printPermutations("ab")
    }

    @Test
    fun threeLetter() {
        // abc
        // bac
        // bca
        // cba
        // cab
        // acb
        println()
        val time = measureNanoTime {
            PermutationsOfAString.printPermutations("abc")
        }
        println("time: $time")
    }

    @Test
    fun duplicateLetters() {
        // aaa x 6
        println()
        PermutationsOfAString.printPermutations("aaa")
    }
}
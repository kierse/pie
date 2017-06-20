package com.pissiphany.pie.ch5

import com.pissiphany.pie.ch5.SixDegreesOfKevinBacon as KB
import com.pissiphany.pie.ch5.SixDegreesOfKevinBacon.Actor
import org.junit.Test
import kotlin.test.assertEquals

class SixDegreesOfKevinBaconTest {
    @Test
    fun baconNumber__given_kevin_bacon() {
        val actor = Actor("Kevin Bacon")
        assertEquals(0, KB.baconNumber(actor))
    }

    @Test
    fun backNumber__unkown_actor() {
        val actor = buildGraph(Actor("Kevin Spacey"))
        assertEquals(-1, KB.baconNumber(actor))
    }

    @Test
    fun backNumber() {
        assertEquals(2, KB.baconNumber(buildGraph()))
    }

    private fun buildGraph(wrongKevin: Actor? = null): Actor {
        val a = Actor("A")
        val b = Actor("B")
        val d = Actor("D")
        val e = Actor("E")
        val f = Actor("F")
        val kb = wrongKevin ?: Actor("Kevin Bacon")

        // A <-> B
        a.linkedActors.add(b)
        b.linkedActors.add(a)

        // A <-> F
        a.linkedActors.add(f)
        f.linkedActors.add(a)

        // B <-> C
        b.linkedActors.add(kb)
        kb.linkedActors.add(b)

        // F <-> E
        f.linkedActors.add(e)
        e.linkedActors.add(f)

        // E <-> D
        e.linkedActors.add(d)
        d.linkedActors.add(e)

        // D <-> KB
        d.linkedActors.add(kb)
        kb.linkedActors.add(d)

        return a
    }
}
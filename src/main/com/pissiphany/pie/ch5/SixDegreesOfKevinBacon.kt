package com.pissiphany.pie.ch5

import java.util.*

object SixDegreesOfKevinBacon {
    class Actor(val name: String) {
        val linkedActors = mutableSetOf<Actor>()
        var baconValue: Int = -1
    }

    fun baconNumber(source: Actor): Int {
        source.baconValue = 0

        val queue = LinkedList<Actor>()
        queue.add(source)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            if (isKevinBacon(current)) return current.baconValue

            for (actor in current.linkedActors) {
                if (actor.baconValue > -1) continue
                actor.baconValue = current.baconValue + 1
                queue.add(actor)
            }
        }

        return -1
    }

    private fun isKevinBacon(actor: Actor) = actor.name == "Kevin Bacon"
}

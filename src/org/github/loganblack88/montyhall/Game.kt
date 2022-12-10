package org.github.loganblack88.montyhall

import java.util.*

class Game() {

    // Door numbers available to choose from.
    private var doors = byteArrayOf(0, 1, 2);

    // Door number with the prize behind it.
    private val prizeDoor: Byte = Random().nextInt(2).toByte()


    fun play(strategy: Strategy): Boolean {

        println("--------------------------------")
        println("Playing new game with strategy:  ${strategy.description}.")

        // Pick the door for the first round.
        val roundOnePick = strategy.pickRoundOne(doors)
        println("Player picks door #${roundOnePick}.")

        // Remove one incorrect door from the 'doors' array.
        val openedDoor = openEmptyDoor(roundOnePick)
        println("Host opens door #${openedDoor}")

        // Ask player to pick from two remaining doors
        val roundTwoPick = strategy.pickRoundTwo(doors, roundOnePick)
        println("Player picks door #${roundTwoPick}")

        // Did player win or lose?
        val won = roundTwoPick == prizeDoor
        if (won) {
            println("Player won!")
        } else {
            println("Player lost. (Prize was behind door #${prizeDoor})")
        }

        return won;
    }


    private fun openEmptyDoor(roundOnePick: Byte): Byte {
        // Host cannot open the door the player picked OR the door with the prize behind it
        val openableDoors = this.doors.filter { it != prizeDoor && it != roundOnePick }
        val doorToOpen = openableDoors.random()

        // Remove the doorToOpen from the available doors.
        this.doors = doors.filter { it != doorToOpen }.toByteArray()
        return doorToOpen
    }

}
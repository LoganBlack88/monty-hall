package org.github.loganblack88.montyhall.strategies

import org.github.loganblack88.montyhall.Strategy

/**
 * Strategy where the player changes their pick in the second round.
 */
class ChangePickStrategy: Strategy {

    override val description = "change door in round two"

    override fun pickRoundOne(doors: ByteArray): Byte {
        return doors.random();
    }

    override fun pickRoundTwo(doors: ByteArray, firstPick: Byte): Byte {
        return doors.first { it != firstPick }
    }
}
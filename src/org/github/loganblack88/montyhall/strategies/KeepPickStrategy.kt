package org.github.loganblack88.montyhall.strategies

import org.github.loganblack88.montyhall.Strategy

/**
 * Strategy where player keeps the door they picked in the first round.
 */
class KeepPickStrategy: Strategy {

    override val description = "keep first door picked"

    override fun pickRoundOne(doors: ByteArray): Byte {
        return doors.random();
    }

    override fun pickRoundTwo(doors: ByteArray, firstPick: Byte): Byte {
        return firstPick;
    }


}
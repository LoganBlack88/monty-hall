package org.github.loganblack88.montyhall

interface Strategy {
    val description: String;
    fun pickRoundOne(doors: ByteArray): Byte;
    fun pickRoundTwo(doors: ByteArray, firstPick: Byte): Byte;
}

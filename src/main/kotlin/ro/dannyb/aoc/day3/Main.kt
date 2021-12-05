package ro.dannyb.aoc.day3

import ro.dannyb.aoc.util.FileUtils

private const val day = "day3"

fun main() {
    val lines = FileUtils.readFile(day)
        .map { it.trim().toList() }
        .fold(listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)) { x, y ->
            x.zip(y) { l: Int, r: Char ->
                val i = r.toString().toInt()
                l + (if (i == 1) 1 else -1)
            }
        }

    val gamma = lines.map { if (it > 0) 1 else 0 }
        .joinToString("")
        .toInt(2)

    val epsilon = lines.map { if (it > 0) 0 else 1 }
        .joinToString("")
        .toInt(2)

    val product = gamma * epsilon

    println(gamma)
    println(epsilon)
    println(product)
}
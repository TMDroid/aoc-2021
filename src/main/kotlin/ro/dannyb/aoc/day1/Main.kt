package ro.dannyb.aoc.day1

import ro.dannyb.aoc.util.FileUtils

private const val day = "day1"

fun main() {
    val lines = FileUtils.readFile(day) { it.trim().toInt() }

    val increased = lines.zipWithNext { first, second -> if (second > first) 1 else 0 }
        .sum()

    println(increased)
}

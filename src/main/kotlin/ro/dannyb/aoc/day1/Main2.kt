package ro.dannyb.aoc.day1

import ro.dannyb.aoc.util.FileUtils

private const val today = "day1"

fun main() {
    val lines = FileUtils.readFile(today) { it.trim().toInt() }
        .windowed(3, 1) { it.sum() }

    val increased = lines.zipWithNext { first, second -> if (second > first) 1 else 0 }
        .sum()

    println(increased)
}
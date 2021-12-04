package ro.dannyb.aoc.day1

import java.io.File

fun main() {
    val path = "src/main/resources/day1/input.txt"
    val lines = File(path).readLines().map { it.trim().toInt() }
        .windowed(3, 1) { it.sum() }

    val increased = lines.zipWithNext { first, second -> if(second > first) 1 else 0 }
        .sum()

    println(increased)
}
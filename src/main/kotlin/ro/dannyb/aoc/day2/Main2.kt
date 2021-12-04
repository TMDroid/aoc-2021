package ro.dannyb.aoc.day2

import ro.dannyb.aoc.util.FileUtils
import java.awt.Point

private const val day = "day2"

fun main() {
    var aim = 0
    val position = Point(0, 0)
    FileUtils.readFile(day) {
        val coords = it.split(" ")
        val distance = coords[1].toInt()
        when (coords[0]) {
            "forward" -> position.translate(distance, aim * distance)
            "up" -> aim -= distance
            "down" -> aim += distance
            else -> RuntimeException("undefined value")
        }
    }

    val product = position.x * position.y
    println(product)
}
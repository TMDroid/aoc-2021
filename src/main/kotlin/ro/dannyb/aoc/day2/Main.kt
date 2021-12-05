package ro.dannyb.aoc.day2

import ro.dannyb.aoc.util.FileUtils
import java.awt.Point

private const val today = "day2"

fun main() {
    val position = Point(0, 0)
    FileUtils.readFile(today) {
        val coords = it.split(" ")
        val distance = coords[1].toInt()
        when (coords[0]) {
            "forward" -> position.translate(distance, 0)
            "up" -> position.translate(0, -distance)
            "down" -> position.translate(0, distance)
            else -> RuntimeException("undefined value")
        }
    }

    val product = position.x * position.y
    println(product)
}
package ro.dannyb.aoc.util

import java.io.File

object FileUtils {

    fun readFile(day: String): List<String> {
        val path = "src/main/resources/$day/input.txt"
        return File(path).readLines()
    }

    fun <T> readFile(day: String, transformation: (String) -> T): List<T> {
        val lines = readFile(day)

        return lines.map(transformation)
    }

}
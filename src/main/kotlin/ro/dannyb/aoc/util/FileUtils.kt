package ro.dannyb.aoc.util

import java.io.File

object FileUtils {

    fun readFile(today: String): List<String> {
        val path = "src/main/resources/$today/input.txt"
        return File(path).readLines()
    }

    fun <T> readFile(today: String, transformation: (String) -> T): List<T> {
        val lines = readFile(today)

        return lines.map(transformation)
    }

}
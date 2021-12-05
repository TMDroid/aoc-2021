package ro.dannyb.aoc.day4

import ro.dannyb.aoc.util.FileUtils

private const val today = "day4"

fun main() {
    val input = FileUtils.readFile(today)
    val numbers = input[0].split(",").map { it.trim().toInt() }

    var boards = parseBingoBoards(input)

    numbers.forEach { pickedNumber ->
        boards = boards.map { board -> board.markNumber(pickedNumber) }
        val winner = getWinners(boards)
        if (winner.isNotEmpty()) {
            val sum = winner.first().sumAll()
            val product = sum * pickedNumber
            
            println("Winning board sum: $sum")
            println("Winning number picked: $pickedNumber")
            println("Winning board: $winner")
            println("Bingo score is: $product")
            return
        }
    }
}
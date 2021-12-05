package ro.dannyb.aoc.day4

import ro.dannyb.aoc.util.FileUtils

private const val today = "day4"

fun main() {
    val input = FileUtils.readFile(today)
    val numbers = input[0].split(",").map { it.trim().toInt() }

    var boards = parseBingoBoards(input)
    val allTimeWinners = mutableMapOf<Int, List<BingoBoard>>()

    numbers.forEach { pickedNumber ->
        boards = boards.map { board -> board.markNumber(pickedNumber) }
        val winners = getWinners(boards)
        if (winners.isNotEmpty()) {
            allTimeWinners[pickedNumber] = winners
            boards = boards.minus(winners)
        }
    }

    val pickedNumber = allTimeWinners.keys.last()
    val lastWinner = allTimeWinners[pickedNumber]!!
    val sum = lastWinner.first().sumAll()
    val product = sum * pickedNumber

    println("Winning board sum: $sum")
    println("Winning number picked: $pickedNumber")
    println("Bingo score is: $product")
}
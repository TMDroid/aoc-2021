package ro.dannyb.aoc.day4

fun parseBingoBoards(lines: List<String>): List<BingoBoard> {
    val boards = lines.subList(2, lines.size)
        .filter { it.isNotEmpty() }
        .chunked(5)

    return boards.map {
        val numbers = it.map { row ->
            row.split(" ")
                .map { number -> number.trim() }
                .filter { number -> number.isNotEmpty() }
                .map { number -> number.toInt() }
        }

        BingoBoard(numbers)
    }
}

fun getWinners(boards: List<BingoBoard>): List<BingoBoard> {
    return boards.filter { it.isWinner() }
}
package ro.dannyb.aoc.day4

data class BingoBoard(
    var numbers: List<List<Int>>
) {
    fun markNumber(markedNumber: Int): BingoBoard {
        val newNumbers = numbers.map { individualNumbers ->
            individualNumbers.map {
                if (it == markedNumber) NUMBER_MARKED else it
            }
        }

        return BingoBoard(newNumbers)
    }

    fun sumAll(): Int {
        return numbers.sumOf { it.sum() }
    }

    fun isWinner(): Boolean {
        val anyRowWinner = numbers.any { it.all { number -> number == NUMBER_MARKED } }
        if (anyRowWinner) return true

        val winningColumns = mutableListOf<Boolean>()
        (0..4).forEach { rowIndex ->
            val isWinningColumns = mutableListOf<Boolean>()
            (0..4).forEach { columnIndex ->
                isWinningColumns.add(numbers[columnIndex][rowIndex] == 0)
            }
            winningColumns.add(isWinningColumns.all { it })
        }
        return winningColumns.any { it }
    }

    companion object {
        private const val NUMBER_MARKED = 0
    }
}

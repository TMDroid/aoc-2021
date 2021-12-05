package ro.dannyb.aoc.day3

import ro.dannyb.aoc.util.FileUtils

private const val today = "day3"

private fun keepNumbersByConditionInPosition(
    numbers: List<List<Char>>,
    position: Int,
    transformation: (Map<Char, Int>) -> Char?
): List<List<Char>> {
    val mostPopularBitInPosition = numbers.map { it[position] }
        .groupingBy { it }
        .eachCount()
        .let(transformation)

    return numbers.filter { it[position] == mostPopularBitInPosition }
}

fun getSuitableNumberByFilteringList(numbers: List<List<Char>>, transformation: (Map<Char, Int>) -> Char?): Int {
    var filteredList = numbers
    var index = 0
    while (filteredList.size > 1) {
        filteredList = keepNumbersByConditionInPosition(filteredList, index, transformation)
        index++
    }

    return filteredList.first()
        .joinToString("")
        .toInt(2)
}

fun main() {
    val lines = FileUtils.readFile(today)
        .map { bits -> bits.trim().toList() }

    val oxygenGeneratorRating = getSuitableNumberByFilteringList(lines) { result ->
        if (result.values.distinct().size == 1) '1'
        else result.maxByOrNull { it.value }?.key
    }
    val co2ScrubberRating = getSuitableNumberByFilteringList(lines) { result ->
        if (result.values.distinct().size == 1) '0'
        else result.minByOrNull { it.value }?.key
    }

    val product = oxygenGeneratorRating * co2ScrubberRating
    println(oxygenGeneratorRating)
    println(co2ScrubberRating)
    println(product)
}
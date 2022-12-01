package com.oudejans.solutions.day01

class MostCalorieDeterminer {

    fun determineHighestCalories(input: String): Int {
        val inputByElf = splitInputByElf(input)
        val convertedToNumbers = convertToNumbers(inputByElf)
        val summedByElf = sumCaloriesByElf(convertedToNumbers)
        return summedByElf.max()
    }

    private fun splitInputByElf(input: String): List<List<String>> =
        input.split("\n\n").map { allCaloriesPerElf -> allCaloriesPerElf.split("\n") }

    private fun convertToNumbers(inputByElf: List<List<String>>): List<List<Int>> =
        inputByElf.map { allCaloriesPerElf -> allCaloriesPerElf.map { it.toInt() } }

    private fun sumCaloriesByElf(convertedToNumbers: List<List<Int>>): List<Int> =
        convertedToNumbers.map { allCaloriesPerElf -> allCaloriesPerElf.sum() }
}
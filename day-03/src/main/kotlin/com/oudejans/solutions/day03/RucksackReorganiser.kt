package com.oudejans.solutions.day03

class RucksackReorganiser {

    fun reorganize(input: String): Int {
        val rucksacks = toRucksacks(input)
        val commonItems = findCommonItems(rucksacks)
        val priorities = determinePriorities(commonItems)
        return priorities.sum()
    }

    private fun toRucksacks(input: String): List<Rucksack> =
        input.split("\n").map { rucksack ->
            Rucksack(
                compartmentOne = rucksack.substring((0 until rucksack.length / 2)),
                compartmentTwo = rucksack.substring(rucksack.length / 2)
            )
        }

    private fun findCommonItems(rucksacks: List<Rucksack>): List<Char> =
        rucksacks.map { rucksack ->
            val commonLetters = rucksack.compartmentOne.toSet().intersect(rucksack.compartmentTwo.toSet())
            commonLetters.first()
        }

    fun determinePriorities(commonItems: List<Char>): List<Int> =
        commonItems.map { letter ->
            if (letter.isUpperCase()) letter.code - 38
            else letter.code - 96
        }

}

data class Rucksack(val compartmentOne: String, val compartmentTwo: String)
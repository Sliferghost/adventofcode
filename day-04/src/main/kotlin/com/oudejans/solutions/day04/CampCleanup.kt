package com.oudejans.solutions.day04

class CampCleanup {
    fun countFullAssignmentOverlap(input: String): Int {
        val pairs = toPairs(input)
        val assignmentsWithFullOverlap = filterAssignmentsFullyWithinEitherOne(pairs)
        return assignmentsWithFullOverlap.count()
    }

    private fun toPairs(input: String): List<Pair<IntRange, IntRange>> =
        input.split("\n").map { assignments ->
            val (leftAssignment, rightAssignment) = assignments.split(",")
            val (leftRangeStart, leftRangeEnd) = leftAssignment.split("-")
            val (rightRangeStart, rightRangeEnd) = rightAssignment.split("-")

            Pair((leftRangeStart.toInt()..leftRangeEnd.toInt()), (rightRangeStart.toInt()..rightRangeEnd.toInt()))
        }

    private fun filterAssignmentsFullyWithinEitherOne(pairs: List<Pair<IntRange, IntRange>>): List<Pair<IntRange, IntRange>> =
        pairs.filter { (leftAssignment, rightAssignment) ->
            leftAssignment within rightAssignment || rightAssignment within leftAssignment
        }

    fun countPartialAssignmentOverlap(input: String): Int {
        val pairs = toPairs(input)
        val assignmentsWithPartialOverlap = filterAssignmentsPartiallyWithinEitherOne(pairs)
        return assignmentsWithPartialOverlap.count()
    }

    private fun filterAssignmentsPartiallyWithinEitherOne(pairs: List<Pair<IntRange, IntRange>>): List<Pair<IntRange, IntRange>> =
        pairs.filter { (leftAssignment, rightAssignment) ->
            leftAssignment partiallyWithin rightAssignment || rightAssignment partiallyWithin leftAssignment
        }
}

infix fun IntRange.within(otherRange: IntRange): Boolean =
    first >= otherRange.first && last <= otherRange.last

infix fun IntRange.partiallyWithin(otherRange: IntRange): Boolean =
    if (first < otherRange.first) {
        last >= otherRange.first
    } else {
        otherRange.last >= first
    }
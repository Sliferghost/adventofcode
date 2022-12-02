package com.oudejans.solutions.day02

import com.oudejans.solutions.day02.Condition.*
import com.oudejans.solutions.day02.Hand.*

typealias Score = Int

class RockPaperScissors {

    fun playWithStrategy(strategy: String): Score {
        val rounds = getRounds(strategy)
        val typedRounds = toTypedRounds(rounds)
        return calculateScore(typedRounds)
    }

    private fun getRounds(strategy: String): List<String> = strategy.split("\n")

    private fun toTypedRounds(rounds: List<String>): List<Round> =
        rounds.map { round ->
            val hands = round.split(" ")
            Round(
                elfPlays = toHand(hands[0]),
                iPlay = toHand(hands[1])
            )
        }

    private fun toHand(hand: String) =
        when (hand) {
            "A" -> ROCK
            "B" -> PAPER
            "C" -> SCISSORS
            "X" -> ROCK
            "Y" -> PAPER
            "Z" -> SCISSORS
            else -> error("Unknown hand: $hand")
        }

    private fun calculateScore(rounds: List<Round>): Int =
        rounds.sumOf { round ->
            scoreBasedOnHandIPlay(round.iPlay) + scoreBasedOnOutcome(round.iPlay, round.elfPlays)
        }

    private fun scoreBasedOnHandIPlay(hand: Hand) =
        when (hand) {
            ROCK -> 1
            PAPER -> 2
            SCISSORS -> 3
        }

    private fun scoreBasedOnOutcome(iPlay: Hand, elfPlays: Hand): Int =
        if (iPlay == elfPlays) 3
        else if (iPlay == ROCK && elfPlays == PAPER) 0
        else if (iPlay == PAPER && elfPlays == SCISSORS) 0
        else if (iPlay == SCISSORS && elfPlays == ROCK) 0
        else 6

    fun playWithUpdatedStrategy(input: String): Int {
        val rounds = getRounds(input)
        val updatedRounds = toTypedUpdatedRounds(rounds)
        val typedRounds = toRoundsFromUpdatedRounds(updatedRounds)
        return calculateScore(typedRounds)
    }

    private fun toTypedUpdatedRounds(rounds: List<String>): List<UpdatedRound> =
        rounds.map { round ->
            val input = round.split(" ")
            UpdatedRound(
                elfPlays = toHand(input[0]),
                winCondition = toWinCondition(input[1])
            )
        }

    private fun toWinCondition(condition: String): Condition =
        when (condition) {
            "X" -> LOSE
            "Y" -> DRAW
            "Z" -> WIN
            else -> error("Unknown condition: $condition")
        }

    private fun toRoundsFromUpdatedRounds(rounds: List<UpdatedRound>): List<Round> =
        rounds.map { round ->
            Round(
                elfPlays = round.elfPlays,
                iPlay = when (round.winCondition) {
                    WIN -> {
                        when (round.elfPlays) {
                            ROCK -> PAPER
                            PAPER -> SCISSORS
                            SCISSORS -> ROCK
                        }
                    }

                    DRAW -> {
                        round.elfPlays
                    }

                    else -> {
                        when (round.elfPlays) {
                            ROCK -> SCISSORS
                            PAPER -> ROCK
                            SCISSORS -> PAPER
                        }
                    }
                }
            )
        }

}

data class Round(val elfPlays: Hand, val iPlay: Hand)
data class UpdatedRound(val elfPlays: Hand, val winCondition: Condition)

enum class Hand {
    ROCK, PAPER, SCISSORS
}

enum class Condition {
    WIN, LOSE, DRAW
}
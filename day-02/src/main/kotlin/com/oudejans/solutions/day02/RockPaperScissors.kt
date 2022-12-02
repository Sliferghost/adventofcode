package com.oudejans.solutions.day02

import com.oudejans.solutions.day02.Condition.*
import com.oudejans.solutions.day02.Hand.*

typealias Score = Int

class RockPaperScissors {

    fun playWithAssumedStrategy(strategy: String): Score {
        val rounds = getRounds(strategy)
        val assumedStrategyPlays = toAssumedPlays(rounds)
        return calculateScore(assumedStrategyPlays)
    }

    private fun getRounds(strategy: String): List<String> = strategy.split("\n")

    private fun toAssumedPlays(rounds: List<String>): List<AssumedPlay> =
        rounds.map { round ->
            val hands = round.split(" ")
            AssumedPlay(
                opponentPlays = toHand(hands[0]),
                iPlay = toHand(hands[1]),
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

    private fun calculateScore(assumedStrategyPlays: List<AssumedPlay>): Int =
        assumedStrategyPlays.sumOf { round ->
            scoreBasedOnHandIPlay(round.iPlay) + scoreBasedOnOutcome(round.iPlay, round.opponentPlays)
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
        val actualStrategyPlays = toActualStrategyPlays(rounds)
        val assumedStrategyPlays = actualPlaysToAssumedPlays(actualStrategyPlays)
        return calculateScore(assumedStrategyPlays)
    }

    private fun toActualStrategyPlays(rounds: List<String>): List<ActualPlay> =
        rounds.map { round ->
            val input = round.split(" ")
            ActualPlay(
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

    private fun actualPlaysToAssumedPlays(actualPlays: List<ActualPlay>): List<AssumedPlay> =
        actualPlays.map { actualPlay ->
            AssumedPlay(
                opponentPlays = actualPlay.elfPlays,
                iPlay = when (actualPlay.winCondition) {
                    WIN -> {
                        when (actualPlay.elfPlays) {
                            ROCK -> PAPER
                            PAPER -> SCISSORS
                            SCISSORS -> ROCK
                        }
                    }

                    DRAW -> {
                        actualPlay.elfPlays
                    }

                    else -> {
                        when (actualPlay.elfPlays) {
                            ROCK -> SCISSORS
                            PAPER -> ROCK
                            SCISSORS -> PAPER
                        }
                    }
                }
            )
        }

}

data class AssumedPlay(val iPlay: Hand, val opponentPlays: Hand)
data class ActualPlay(val elfPlays: Hand, val winCondition: Condition)

enum class Hand {
    ROCK, PAPER, SCISSORS
}

enum class Condition {
    WIN, LOSE, DRAW
}
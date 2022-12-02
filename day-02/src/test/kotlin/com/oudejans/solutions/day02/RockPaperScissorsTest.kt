package com.oudejans.solutions.day02

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.oudejans.solutions.helpers.questions.input.QuestionInputDownloader
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RockPaperScissorsTest {

    private lateinit var subject: RockPaperScissors

    @BeforeEach
    fun setup() {
        subject = RockPaperScissors()
    }

    @Test
    fun `should be able to play the game following the example guide`() {
        // Given
        val input = """
            A Y
            B X
            C Z
        """.trimIndent()
        // When
        val result = subject.playWithAssumedStrategy(input)
        // Then
        assertThat(result).isEqualTo(15)
    }

    @Test
    fun `should be able to give first answer`() {
        // Given
        val input = QuestionInputDownloader().getInput(2)
        // When
        val result = subject.playWithAssumedStrategy(input)
        // Then
        println(result)
    }

    @Test
    fun `should be able to play the game following the correct guide`() {
        // Given
        val input = """
            A Y
            B X
            C Z
        """.trimIndent()
        // When
        val result = subject.playWithUpdatedStrategy(input)
        // Then
        assertThat(result).isEqualTo(12)
    }

    @Test
    fun `should be able to give the second answer`() {
        // Given
        val input = QuestionInputDownloader().getInput(2)
        // When
        val result = subject.playWithUpdatedStrategy(input)
        // Then
        println(result)
    }

}
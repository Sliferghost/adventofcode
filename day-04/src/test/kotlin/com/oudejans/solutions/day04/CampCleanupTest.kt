package com.oudejans.solutions.day04

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import com.oudejans.solutions.helpers.questions.input.QuestionInputDownloader
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CampCleanupTest {

    private lateinit var subject: CampCleanup

    @BeforeEach
    fun setup() {
        subject = CampCleanup()
    }

    @Test
    fun `should be able to tell which assignments are fully contained within the other pair's assignment`() {
        // Given
        val input = """
            2-4,6-8
            2-3,4-5
            5-7,7-9
            2-8,3-7
            6-6,4-6
            2-6,4-8
        """.trimIndent()
        // When
        val result = subject.countFullAssignmentOverlap(input)
        // Then
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `should be able to solve the first answer`() {
        // Given
        val input = QuestionInputDownloader().getInput(4)
        // When
        val result = subject.countFullAssignmentOverlap(input)
        // Then
        println(result)
    }

    @Test
    fun `should be able to tell which assignments overlap for any number of sections of the other pair's assignment`() {
        // Given
        val input = """
            2-4,6-8
            2-3,4-5
            5-7,7-9
            2-8,3-7
            6-6,4-6
            2-6,4-8
        """.trimIndent()
        // When
        val result = subject.countPartialAssignmentOverlap(input)
        // Then
        assertThat(result).isEqualTo(4)
    }

    @Test
    fun `test partially within`() {
        // Given
        val input = listOf(
            Pair((1..5), (3..8)),
            Pair((3..8), (1..5)),
            Pair((1..5), (6..8)),
            Pair((6..8), (1..5)),
        )
        // When
        val (firstResult, secondResult, thirdResult) = input.map { (left, right) -> left partiallyWithin right || right partiallyWithin left }
        // Then
        assertThat(firstResult).isTrue()
        assertThat(secondResult).isTrue()
        assertThat(thirdResult).isFalse()
    }

    @Test
    fun `should be able to solve the second answer`() {
        // Given
        val input = QuestionInputDownloader().getInput(4)
        // When
        val result = subject.countPartialAssignmentOverlap(input)
        // Then
        println(result)
    }

}
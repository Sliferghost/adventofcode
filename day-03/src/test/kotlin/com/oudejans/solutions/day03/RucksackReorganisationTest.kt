package com.oudejans.solutions.day03

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.oudejans.solutions.helpers.questions.input.QuestionInputDownloader
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RucksackReorganisationTest {

    private lateinit var subject: RucksackReorganiser

    @BeforeEach
    fun setup() {
        subject = RucksackReorganiser()
    }

    @Test
    fun `should sum the priority of all common items in each compartment per rucksack`() {
        // Given
        val input = """
            vJrwpWtwJgWrhcsFMMfFFhFp
            jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
            PmmdzqPrVvPwwTWBwg
            wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
            ttgJtRGJQctTZtZT
            CrZsJsPPZsGzwwsLwLmpwMDw
        """.trimIndent()
        // When
        val result = subject.reorganize(input)
        // Then
        assertThat(result).isEqualTo(157)
    }

    @Test
    fun `should be able to solve first answer`() {
        // Given
        val input = QuestionInputDownloader().getInput(3)
        // When
        val result = subject.reorganize(input)
        // Then
        println(result)
    }

}
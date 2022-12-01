package com.oudejans.solutions.day01

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.oudejans.solutions.helpers.questions.input.QuestionInputDownloader
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MostCalorieDeterminerTest {

    private lateinit var subject: MostCalorieDeterminer

    @BeforeEach
    fun setup() {
        subject = MostCalorieDeterminer()
    }

    @Test
    fun `should be able to determine the Elf with the highest calorie count`(){
        // Given
        val input = """
            1000
            2000
            3000

            4000

            5000
            6000

            7000
            8000
            9000

            10000
        """.trimIndent()
        // When
        val output = subject.determineHighestCalories(input)
        // Then
        assertThat(output).isEqualTo(24000)
    }

    @Test
    fun `should be able to give the first answer`(){
        // Given
        val input = QuestionInputDownloader().getInput(1)
        // When
        val output = subject.determineHighestCalories(input)
        // Then
        println("First answer: $output")
    }

    @Test
    fun `should also be able to determine the sum of the three highest calorie counts`(){
        // Given
        val input = """
            1000
            2000
            3000

            4000

            5000
            6000

            7000
            8000
            9000

            10000
        """.trimIndent()
        // When
        val output = subject.determineThreeHighestCalories(input)
        // Then
        assertThat(output).isEqualTo(45000)
    }

    @Test
    fun `should be able to give the second answer`(){
        // Given
        val input = QuestionInputDownloader().getInput(1)
        // When
        val output = subject.determineThreeHighestCalories(input)
        // Then
        println("Second answer: $output")
    }

}
package com.oudejans.solutions.day01

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class FirstTest {

    @Test
    fun `should be able to run tests`() {
        // Given
        val a = 1
        val b = 2
        // When
        val result = a + b
        // Then
        assertThat(result).isEqualTo(3)
    }

}
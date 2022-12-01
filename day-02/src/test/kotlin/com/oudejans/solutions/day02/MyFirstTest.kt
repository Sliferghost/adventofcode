package com.oudejans.solutions.day02

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class MyFirstTest {

    @Test
    fun `should be able to run`() {
        // Given
        val a = 1
        val b = 2
        // When
        val output = a + b
        // Then
        assertThat(output).isEqualTo(3)
    }

}
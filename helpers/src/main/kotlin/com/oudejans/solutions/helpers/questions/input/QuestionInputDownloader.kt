package com.oudejans.solutions.helpers.questions.input

class QuestionInputDownloader {

    fun getInput(day: Int): String =
        javaClass.getResource("/input/day-$day.txt")?.readText()
            ?: error("Couldn't read input for day $day, maybe the input file is not downloaded yet to resources/input/day-$day.txt")
}
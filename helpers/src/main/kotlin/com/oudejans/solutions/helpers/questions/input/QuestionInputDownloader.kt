package com.oudejans.solutions.helpers.questions.input

class QuestionInputDownloader {

    // Note: we cannot download the input directly from the website, they prefer we download the file once, and then go from there. Hence the local file reading
    fun getInput(day: Int): String =
        javaClass.getResource("/input/day-$day.txt")?.readText()
            ?: error("Couldn't read input for day $day, maybe the input file is not downloaded yet to resources/input/day-$day.txt")
}
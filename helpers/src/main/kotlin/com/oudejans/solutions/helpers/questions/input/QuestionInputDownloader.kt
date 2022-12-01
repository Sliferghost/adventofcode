package com.oudejans.solutions.helpers.questions.input

import java.net.URL

class QuestionInputDownloader {

    fun getInput(day: Int): String =
        URL("https://adventofcode.com/2022/day/$day/input").readText()

}
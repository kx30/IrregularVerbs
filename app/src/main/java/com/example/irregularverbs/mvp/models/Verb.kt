package com.example.irregularverbs.mvp.models

data class Verb(
    val firstForm: String,
    val secondForm: String,
    val thirdForm: String,
    val complexity: Int = 1,
    var translate: String,
    var amountOfCorrectAnswers: Int = 0
)


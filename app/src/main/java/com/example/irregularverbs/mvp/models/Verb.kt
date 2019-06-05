package com.example.irregularverbs.mvp.models

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass //TODO CHECK USING SERIALIZABLE - FIXED
open class Verb(
    var firstForm: String = "",
    var secondForm: String = "",
    var thirdForm: String = "",
    var level: Int = 1,
    var translate: String = "",
    var amountOfCorrectAnswers: Int = 0,
    var amountOfMistakes: Int = 0
) : RealmObject() {

    companion object {
        const val AMOUNT_OF_ANSWERS_TO_COMPLETE = 6
    }
}


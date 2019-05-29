package com.example.irregularverbs.mvp.models

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class Verb (
    var firstForm: String = "",
    var secondForm: String = "",
    var thirdForm: String = "",
    var complexity: Int = 1,
    var translate: String = "",
    var amountOfCorrectAnswers: Int = 0
) : RealmObject()


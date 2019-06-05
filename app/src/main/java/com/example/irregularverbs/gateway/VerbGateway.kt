package com.example.irregularverbs.gateway

import com.example.irregularverbs.mvp.models.Verb

interface VerbGateway {
    fun loadVerbs(level: Int?): ArrayList<Verb>
    fun loadTooBadVerbs(): ArrayList<Verb>
    fun loadSoSoBVerbs(): ArrayList<Verb>
    fun loadExactlyKnownVerbs(): ArrayList<Verb>
    fun saveVerbs()
    fun changeAmountOfAnswers(currentVerb: Verb)
    fun changeAmountOfMistakes(currentVerb: Verb)
    fun deleteLevelProgress(level: Int)
    fun resetAllProgress()
    fun getAmountOfRightAnswers(): Int
    fun getAmountOfWrongAnswers(): Int
}
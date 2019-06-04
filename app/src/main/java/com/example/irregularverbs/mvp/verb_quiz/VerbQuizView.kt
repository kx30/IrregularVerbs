package com.example.irregularverbs.mvp.verb_quiz

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.irregularverbs.mvp.models.Verb

@StateStrategyType(AddToEndSingleStrategy::class)
interface VerbQuizView: MvpView {
    fun displayNewVerb(verb: Verb, formOfVerb: Int)
    fun displayIfAnswerWrong(verb: Verb)
    fun displayIfAnswerCorrect()
    fun displayProgress(progressPercent: Float)
    fun finishActivityIfCompleted()
    fun showToast(message: String)
    fun initRealm()
}
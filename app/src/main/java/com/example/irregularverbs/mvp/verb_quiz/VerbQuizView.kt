package com.example.irregularverbs.mvp.verb_quiz

import com.arellomobile.mvp.MvpView
import com.example.irregularverbs.mvp.models.Verb

interface VerbQuizView: MvpView {
    fun displayNewVerb(verb: Verb, formOfVerb: Int)
    fun displayIfAnswerWrong(verb: Verb)
    fun displayIfAnswerCorrect()
    fun displayProgress(progressPercent: Float)
    fun finishActivityIfCompleted()
    fun showToast(message: String)
    fun initRealm()
}
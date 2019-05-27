package com.example.irregularverbs.mvp.views

import com.arellomobile.mvp.MvpView
import com.example.irregularverbs.mvp.models.Verb

interface VerbQuizView: MvpView {
    fun displayNewVerb(verb: Verb, formOfVerb: Int)
    fun displayIfAnswerWrong(verb: Verb)
    fun displayIfAnswerCorrect()
    fun displayProgress(progressPercent: Float)
    fun finishActivityIfCompleted()
    fun getComplexity(complexity: Int)
    fun showToast(message: String)
}
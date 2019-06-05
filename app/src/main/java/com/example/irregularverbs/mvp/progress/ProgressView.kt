package com.example.irregularverbs.mvp.progress

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.irregularverbs.mvp.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProgressView: BaseView, MvpView {
    fun startVerbListActivity(level: Int?)
    fun setFirstLevelProgressTextView(progressPercent: Float)
    fun setSecondLevelProgressTextView(progressPercent: Float)
    fun setThirdLevelProgressTextView(progressPercent: Float)
    fun setFourthLevelProgressTextView(progressPercent: Float)
    fun setFifthLevelProgressTextView(progressPercent: Float)
    fun setAmountOfAnswersTextView(rightAnswers: String, wrongAnswers: String)
    fun setTooBadTextView(amountOfTooBadVerbs: String)
    fun setSoSoTextView(amountOfSoSoVerbs: String)
    fun setExactlyKnownTextView(amountOfExactlyKnownTextView: String)
    fun initRealm()
}
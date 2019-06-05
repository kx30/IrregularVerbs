package com.example.irregularverbs.mvp.choose_level_flashcard

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.irregularverbs.mvp.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface ChooseLevelFlashcardView: BaseView, MvpView {
    fun initRealm()
    fun startFlashCardActivity(level: Int)
    fun startVerbListActivity(level: Int?)
}
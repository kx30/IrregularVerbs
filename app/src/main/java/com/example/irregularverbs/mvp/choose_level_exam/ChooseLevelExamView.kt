package com.example.irregularverbs.mvp.choose_level_exam

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ChooseLevelExamView: MvpView {
    fun startVerbQuizActivity(level: Int)
    fun firstLevelIsCompleted()
    fun secondLevelIsCompleted()
    fun thirdLevelIsCompleted()
    fun fourthLevelIsCompleted()
    fun fifthLevelIsCompleted()
}
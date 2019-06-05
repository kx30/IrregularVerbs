package com.example.irregularverbs.mvp.launcher

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface LauncherView: MvpView {
    fun saveVerbsIfFirstLaunch()
    fun startChooseLevelExamActivity()
    fun startChooseLevelFlashcardActivity()
    fun startVerbsListActivity()
    fun startProgressActivity()
}
package com.example.irregularverbs.mvp.base

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface BaseView: MvpView { //TODO STRATEGY
    fun unlockResultButton(category: Int)
}
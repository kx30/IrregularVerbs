package com.example.irregularverbs.mvp.flashcard

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.irregularverbs.mvp.models.Verb

@StateStrategyType(AddToEndSingleStrategy::class)
interface FlashcardView: MvpView {
    fun initRecyclerView(verbList: ArrayList<Verb>)
    fun initRealm()
}
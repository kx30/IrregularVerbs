package com.example.irregularverbs.mvp.verb_list

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.irregularverbs.mvp.models.Verb

@StateStrategyType(AddToEndSingleStrategy::class)
interface VerbListView: MvpView {
    fun notifyDataSetChangedAdapter()
    fun initAdapter(searchResultVerbs: ArrayList<Verb>)
}

interface IrregularThings {
    fun getChosenLevelForVerbs(): Int
}
package com.example.irregularverbs.mvp.verb_list

import com.arellomobile.mvp.MvpView

interface VerbListView: MvpView {
    fun notifyDataSetChangedAdapter()
}

interface IrregularThings {
    fun getChosenLevelForVerbs(): Int
}
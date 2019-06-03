package com.example.irregularverbs.mvp.verb_list

import com.arellomobile.mvp.MvpView
import com.example.irregularverbs.mvp.models.Verb

interface VerbListView: MvpView {
    fun setChosenLevelInPresenter()
    fun notifyDataSetChangedAdapter()
}
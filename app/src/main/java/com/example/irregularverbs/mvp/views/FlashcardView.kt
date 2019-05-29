package com.example.irregularverbs.mvp.views

import com.arellomobile.mvp.MvpView
import com.example.irregularverbs.mvp.models.Verb

interface FlashcardView: MvpView {
    fun initRecyclerView(verbList: ArrayList<Verb>)
//    fun getLevel(level: Int)
}
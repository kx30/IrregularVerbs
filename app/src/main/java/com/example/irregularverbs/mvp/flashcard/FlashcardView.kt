package com.example.irregularverbs.mvp.flashcard

import com.arellomobile.mvp.MvpView
import com.example.irregularverbs.mvp.models.Verb

interface FlashcardView: MvpView {
    fun initRecyclerView(verbList: ArrayList<Verb>)
    fun initRealm()
}
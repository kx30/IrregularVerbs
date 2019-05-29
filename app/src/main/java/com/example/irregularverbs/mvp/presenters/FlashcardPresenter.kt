package com.example.irregularverbs.mvp.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.irregularverbs.gateway.local.LocalVerbGateway
import com.example.irregularverbs.mvp.models.Verb
import com.example.irregularverbs.mvp.views.FlashcardView

@InjectViewState
class FlashcardPresenter: MvpPresenter<FlashcardView>() {

    private var level = 1
    private lateinit var verbList: ArrayList<Verb>

    fun setLevel(level: Int) {
        this.level = level
    }

    fun getVerbList() {
//        verbList = LocalVerbGateway().loadVerbs(level)
        viewState.initRecyclerView(verbList)
    }
}
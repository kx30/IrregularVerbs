package com.example.irregularverbs.mvp.flashcard

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.irregularverbs.gateway.realm.RealmVerbGateway
import com.example.irregularverbs.mvp.models.Verb

@InjectViewState
class FlashcardPresenter: MvpPresenter<FlashcardView>() {

    private var level = 1
    private lateinit var verbList: ArrayList<Verb>


    fun setLevel(level: Int) {
        this.level = level
    }

    override fun onFirstViewAttach() {
        getVerbList()
        super.onFirstViewAttach()
    }

    private fun getVerbList() {
        viewState.initRealm()
        verbList = RealmVerbGateway().loadVerbs(level)
        viewState.initRecyclerView(verbList)
    }
}
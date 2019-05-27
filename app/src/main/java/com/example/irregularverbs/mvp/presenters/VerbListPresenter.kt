package com.example.irregularverbs.mvp.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.irregularverbs.gateway.local.LocalVerbGateway
import com.example.irregularverbs.mvp.models.Verb
import com.example.irregularverbs.mvp.views.VerbListView

@InjectViewState
class VerbListPresenter : MvpPresenter<VerbListView>() {

    private lateinit var verbList: ArrayList<Verb>

    init {
        getVerbList()
    }

    private fun getVerbList() {
        verbList = LocalVerbGateway().loadVerbs(null)
        viewState.initRecyclerView(verbList)
    }
}
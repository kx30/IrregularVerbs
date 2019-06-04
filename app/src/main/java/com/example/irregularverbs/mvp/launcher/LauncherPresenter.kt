package com.example.irregularverbs.mvp.launcher

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.irregularverbs.gateway.realm.RealmVerbGateway

@InjectViewState
class LauncherPresenter: MvpPresenter<LauncherView>() {

    fun saveVerbsInRealm() {
        RealmVerbGateway().saveVerbs()
    }

    fun loadVerbs() {
        RealmVerbGateway().loadVerbs(null)
    }

    fun startChooseLevelExamActivity() {
        viewState.startChooseLevelExamActivity()
    }

    fun startVerbsListActivity() {
        viewState.startVerbsListActivity()
    }

    fun startChooseLevelFlashcardActivity() {
        viewState.startChooseLevelFlashcardActivity()
    }

    fun startProgressActivity() {
        viewState.startProgressActivity()
    }
}
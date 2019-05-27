package com.example.irregularverbs.mvp.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.irregularverbs.mvp.views.LauncherView

@InjectViewState
class LauncherPresenter: MvpPresenter<LauncherView>() {

    fun startChooseComplexityExamActivity() {
        viewState.startChooseComplexityExamActivity()
    }

    fun startVerbsListActivity() {
        viewState.startVerbsListActivity()
    }
}
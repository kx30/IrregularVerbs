package com.example.irregularverbs.mvp.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.irregularverbs.mvp.views.LauncherView

@InjectViewState
class LauncherPresenter(): MvpPresenter<LauncherView>() {

    fun startChooseLevelExamActivity() {
        viewState.startChooseLevelExamActivity()
    }

    fun startVerbsListActivity() {
        viewState.startVerbsListActivity()
    }

    fun startChooseLevelFlashcardActivity() {
        viewState.startChooseLevelFlashcardActivity()
    }
}
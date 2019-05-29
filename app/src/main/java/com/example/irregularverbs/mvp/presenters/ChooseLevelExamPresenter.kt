package com.example.irregularverbs.mvp.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.irregularverbs.mvp.views.ChooseLevelExamView

@InjectViewState
class ChooseLevelExamPresenter: MvpPresenter<ChooseLevelExamView>() {

    fun startVerbQuizActivityButtonWasClicked(level: Int) {
        viewState.startVerbQuizActivity(level)
    }
}
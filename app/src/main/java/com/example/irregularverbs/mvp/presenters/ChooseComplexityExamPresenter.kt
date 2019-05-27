package com.example.irregularverbs.mvp.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.irregularverbs.mvp.views.ChooseComplexityExamView

@InjectViewState
class ChooseComplexityExamPresenter: MvpPresenter<ChooseComplexityExamView>() {

    fun startVerbQuizActivityButtonWasClicked(complexity: Int) {
        viewState.startVerbQuizActivity(complexity)
    }
}
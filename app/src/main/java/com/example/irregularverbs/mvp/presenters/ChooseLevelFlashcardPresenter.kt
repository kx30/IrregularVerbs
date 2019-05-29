package com.example.irregularverbs.mvp.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.irregularverbs.mvp.views.ChooseLevelFlashcardView

@InjectViewState
class ChooseLevelFlashcardPresenter: MvpPresenter<ChooseLevelFlashcardView>() {

    fun startVerbQuizActivityButtonWasClicked(level: Int) {
        viewState.startFlashCardActivity(level)
    }
}
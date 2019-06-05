package com.example.irregularverbs.mvp.choose_level_flashcard

import com.arellomobile.mvp.InjectViewState
import com.example.irregularverbs.mvp.base.BasePresenter

@InjectViewState
class ChooseLevelFlashcardPresenter: BasePresenter<ChooseLevelFlashcardView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        checkConditionAndUnlockButton()
    }

    fun startFlashCardActivity(level: Int) {
        viewState.startFlashCardActivity(level)
    }

    fun startVerbListActivity(level: Int?) {
        viewState.startVerbListActivity(level)
    }
}
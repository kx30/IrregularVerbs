package com.example.irregularverbs.mvp.choose_level_flashcard

import com.arellomobile.mvp.MvpView
import com.example.irregularverbs.mvp.base.BaseView

interface ChooseLevelFlashcardView: BaseView, MvpView {
    fun initRealm()
    fun startFlashCardActivity(level: Int)
    fun startVerbListActivity(level: Int?)
}
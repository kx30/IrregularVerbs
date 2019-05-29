package com.example.irregularverbs.mvp.views

import com.arellomobile.mvp.MvpView

interface ChooseLevelFlashcardView: MvpView {
    fun startFlashCardActivity(level: Int)
}
package com.example.irregularverbs.mvp.views

import com.arellomobile.mvp.MvpView

interface ChooseLevelExamView: MvpView {
    fun startVerbQuizActivity(level: Int)
}
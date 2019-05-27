package com.example.irregularverbs.mvp.views

import com.arellomobile.mvp.MvpView

interface ChooseComplexityExamView: MvpView {
    fun startVerbQuizActivity(complexity: Int)
}
package com.example.irregularverbs.mvp.views

import com.arellomobile.mvp.MvpView

interface LauncherView: MvpView {
    fun startChooseComplexityExamActivity()
    fun startVerbsListActivity()
}
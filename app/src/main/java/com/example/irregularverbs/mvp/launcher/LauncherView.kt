package com.example.irregularverbs.mvp.launcher

import com.arellomobile.mvp.MvpView

interface LauncherView: MvpView {
    fun saveVerbsIfFirstLaunch()
    fun startChooseLevelExamActivity()
    fun startChooseLevelFlashcardActivity()
    fun startVerbsListActivity()
    fun startProgressActivity()
}
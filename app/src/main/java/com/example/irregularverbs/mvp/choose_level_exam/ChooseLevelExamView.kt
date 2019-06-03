package com.example.irregularverbs.mvp.choose_level_exam

import com.arellomobile.mvp.MvpView

interface ChooseLevelExamView: MvpView {
    fun startVerbQuizActivity(level: Int)
    fun firstLevelIsCompleted()
    fun secondLevelIsCompleted()
    fun thirdLevelIsCompleted()
    fun fourthLevelIsCompleted()
    fun fifthLevelIsCompleted()
}
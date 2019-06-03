package com.example.irregularverbs.mvp.choose_level_exam

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.irregularverbs.gateway.realm.RealmVerbGateway
import com.example.irregularverbs.mvp.models.Verb
import com.example.irregularverbs.mvp.models.Verb.Companion.AMOUNT_OF_ANSWERS_TO_COMPLETE

@InjectViewState
class ChooseLevelExamPresenter : MvpPresenter<ChooseLevelExamView>() {

    private var firstLevelProgress: Float = 0f
    private var secondLevelProgress: Float = 0f
    private var thirdLevelProgress: Float = 0f
    private var fourthLevelProgress: Float = 0f
    private var fifthLevelProgress: Float = 0f
    private var totalAmountOfCorrectAnswers: Int = 0
    private lateinit var verbs: ArrayList<Verb>


    fun startVerbQuizActivityButtonWasClicked(level: Int) {
        viewState.startVerbQuizActivity(level)
    }

    fun deleteProgressOfLevel(level: Int) {
        RealmVerbGateway().deleteLevelProgress(level)
    }

    fun initPresenter() {
        for (i in 1..5) {
            verbs = RealmVerbGateway().loadVerbs(i)
            verbs.forEach { verb ->
                totalAmountOfCorrectAnswers += verb.amountOfCorrectAnswers
            }
            when (i) {
                1 -> {
                    firstLevelProgress = countingProgressLevel()
                    if (isProgressCompleted(firstLevelProgress)) {
                        viewState.firstLevelIsCompleted()
                    }
                }
                2 -> {
                    secondLevelProgress = countingProgressLevel()
                    if (isProgressCompleted(secondLevelProgress)) {
                        viewState.secondLevelIsCompleted()
                    }
                }
                3 -> {
                    thirdLevelProgress = countingProgressLevel()
                    if (isProgressCompleted(thirdLevelProgress)) {
                        viewState.thirdLevelIsCompleted()
                    }
                }
                4 -> {
                    fourthLevelProgress = countingProgressLevel()
                    if (isProgressCompleted(fourthLevelProgress)) {
                        viewState.fourthLevelIsCompleted()
                    }
                }
                5 -> {
                    fifthLevelProgress = countingProgressLevel()
                    if (isProgressCompleted(fifthLevelProgress)) {
                        viewState.fifthLevelIsCompleted()
                    }
                }
            }
            totalAmountOfCorrectAnswers = 0
        }
    }

    private fun countingProgressLevel(): Float {
        return 100 / (verbs.size * AMOUNT_OF_ANSWERS_TO_COMPLETE).toFloat() * totalAmountOfCorrectAnswers.toFloat()
    }

    private fun isProgressCompleted(currentProgress: Float): Boolean = currentProgress == 100f
}
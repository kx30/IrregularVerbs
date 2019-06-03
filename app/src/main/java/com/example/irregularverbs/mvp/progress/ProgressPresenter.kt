package com.example.irregularverbs.mvp.progress

import com.arellomobile.mvp.InjectViewState
import com.example.irregularverbs.gateway.realm.RealmVerbGateway
import com.example.irregularverbs.mvp.base.BasePresenter
import com.example.irregularverbs.mvp.models.Verb
import com.example.irregularverbs.mvp.models.Verb.Companion.AMOUNT_OF_ANSWERS_TO_COMPLETE

@InjectViewState
class ProgressPresenter : BasePresenter<ProgressView>() {

    private var progressPercent: Float = 0f
    private var totalAmountOfCorrectAnswers: Int = 0
    private lateinit var verbs: ArrayList<Verb>


    fun startVerbListActivity(level: Int?) {
        viewState.startVerbListActivity(level)
    }

    fun resetAllProgress() {
        RealmVerbGateway().resetAllProgress()
    }

    fun setCurrentProgress() {
        setFirstLevelProgressText()
        setSecondLevelProgressText()
        setThirdLevelProgressText()
        setFourthLevelProgressText()
        setFifthLevelProgressText()
        setAmountOfAnswersText()
        setTooBadTextView()
        setSoSoTextView()
        setExactlyKnownTextView()
    }

    private fun setFirstLevelProgressText() {
        setProgressValues(1)
        viewState.setFirstLevelProgressTextView(progressPercent)
    }

    private fun setSecondLevelProgressText() {
        setProgressValues(2)
        viewState.setSecondLevelProgressTextView(progressPercent)
    }

    private fun setThirdLevelProgressText() {
        setProgressValues(3)
        viewState.setThirdLevelProgressTextView(progressPercent)
    }

    private fun setFourthLevelProgressText() {
        setProgressValues(4)
        viewState.setFourthLevelProgressTextView(progressPercent)
    }

    private fun setFifthLevelProgressText() {
        setProgressValues(5)
        viewState.setFifthLevelProgressTextView(progressPercent)
    }

    private fun setProgressValues(level: Int) {
        loadVerbs(level)
        progressPercent = countingProgressLevel()
        totalAmountOfCorrectAnswers = 0
    }

    private fun loadVerbs(level: Int) {
        verbs = RealmVerbGateway().loadVerbs(level)
        verbs.forEach { verb ->
            totalAmountOfCorrectAnswers += verb.amountOfCorrectAnswers
        }
    }

    private fun countingProgressLevel(): Float {
        return 100 / (verbs.size * AMOUNT_OF_ANSWERS_TO_COMPLETE).toFloat() * totalAmountOfCorrectAnswers.toFloat()
    }

    private fun setAmountOfAnswersText() {
        viewState.initRealm()
        val rightAnswers = RealmVerbGateway().getAmountOfRightAnswers().toString()
        val wrongAnswers = RealmVerbGateway().getAmountOfWrongAnswers().toString()
        viewState.setAmountOfAnswersTextView(rightAnswers, wrongAnswers)
    }

    private fun setTooBadTextView(){
        val verbs = RealmVerbGateway().loadTooBadVerbs()
        viewState.setTooBadTextView(changeCounterAmountOfVerbs(verbs).toString())
    }

    private fun setSoSoTextView() {
        val verbs = RealmVerbGateway().loadSoSoBVerbs()
        viewState.setSoSoTextView(changeCounterAmountOfVerbs(verbs).toString())
    }

    private fun setExactlyKnownTextView() {
        val verbs = RealmVerbGateway().loadSoSoBVerbs()
        viewState.setExactlyKnownTextView(changeCounterAmountOfVerbs(verbs).toString())
    }

    private fun changeCounterAmountOfVerbs(verbs: ArrayList<Verb>): Int {
        var counter = 0
        repeat(verbs.size) {
            counter++
        }
        return counter
    }
}
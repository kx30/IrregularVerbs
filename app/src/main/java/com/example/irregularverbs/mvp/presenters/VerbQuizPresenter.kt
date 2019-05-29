package com.example.irregularverbs.mvp.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.irregularverbs.gateway.local.LocalVerbGateway
import com.example.irregularverbs.mvp.models.Verb
import com.example.irregularverbs.mvp.views.VerbQuizView
import java.util.*
import kotlin.random.Random

@InjectViewState
class VerbQuizPresenter : MvpPresenter<VerbQuizView>() {

    private lateinit var verbs: ArrayList<Verb>
    private var level = 1
    private var currentVerbIndex = 0
    private var formOfVerb: Int = 0
    private var totalAmountOfCorrectAnswers = 0
    private var progressPercent: Float = 0f

    fun initVerbs() {
//        verbs = LocalVerbGateway().loadVerbs(level)
        verbs.shuffle()
    }

    fun okButtonWasClicked(result: String) {
        checkVerbIsCorrectly(result)
        getNewVerb()
    }

    fun setLevel(level: Int) {
        this.level = level
    }

    private fun checkVerbIsCorrectly(result: String) {
        if (formOfVerb == 2) {
            if (result == getCurrentVerb().secondForm) {
                changeValuesAfterRightAnswer()
            } else {
                viewState.displayIfAnswerWrong(getCurrentVerb())
            }
        } else if (formOfVerb == 3) {
            if (result == getCurrentVerb().thirdForm) {
                changeValuesAfterRightAnswer()
            } else {
                viewState.displayIfAnswerWrong(getCurrentVerb())
            }
        }
        incrementVerbIndex()
    }

    private fun changeValuesAfterRightAnswer() {
        viewState.displayIfAnswerCorrect()
        getCurrentVerb().amountOfCorrectAnswers++
        totalAmountOfCorrectAnswers++
        displayProgress()
    }

    fun getNewVerb() {
        formOfVerb = Random.nextInt(2, 4)
        viewState.displayNewVerb(getCurrentVerb(), formOfVerb)

        checkIsVerbsAreAnswered()
    }

    private fun checkIsVerbsAreAnswered() {
        if (getCurrentVerb().amountOfCorrectAnswers == 2) {
            var isCompleted = true
            for (verb in verbs) {
                if (verb.amountOfCorrectAnswers != 2) {
                    incrementVerbIndex()
                    getNewVerb()
                    isCompleted = false
                    break
                }
            }
            if (isCompleted) {
                viewState.finishActivityIfCompleted()
            }
        }
    }

    private fun displayProgress() {
        progressPercent = 100 / (verbs.size * 2).toFloat() * totalAmountOfCorrectAnswers.toFloat()
        viewState.displayProgress(progressPercent)
    }

    private fun incrementVerbIndex() {
        if (currentVerbIndex == verbs.size - 1) {
            currentVerbIndex = 0
            verbs.shuffle()
        } else {
            currentVerbIndex++
        }
    }

    private fun getCurrentVerb(): Verb {
        return verbs[currentVerbIndex]
    }
}
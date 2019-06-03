package com.example.irregularverbs.mvp.verb_quiz

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.irregularverbs.gateway.realm.RealmVerbGateway
import com.example.irregularverbs.mvp.models.Verb
import com.example.irregularverbs.mvp.models.Verb.Companion.AMOUNT_OF_ANSWERS_TO_COMPLETE
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


    fun okButtonWasClicked(result: String) {
        checkVerbIsCorrectly(result)
        getNewVerb()
    }

    fun loadIrregularVerbs(level: Int) {
        setLevel(level)
        initVerbs()
        getNewVerb()
        loadCurrentProgress()
    }

    private fun setLevel(level: Int) {
        this.level = level
    }

    private fun initVerbs() {
        viewState.initRealm()
        verbs = RealmVerbGateway().loadVerbs(level)
        verbs.shuffle()
    }

    private fun getNewVerb() {
        formOfVerb = Random.nextInt(2, 4)
        viewState.displayNewVerb(getCurrentVerb(), formOfVerb)

        checkIsVerbsAreAnswered()
    }

    private fun loadCurrentProgress() {
        verbs.forEach { verb ->
            totalAmountOfCorrectAnswers += verb.amountOfCorrectAnswers
        }
        displayProgress()
    }

    private fun checkVerbIsCorrectly(result: String) {
        if (formOfVerb == 2) {
            if (result == getCurrentVerb().secondForm) {
                changeValuesAfterRightAnswer()
            } else {
                changeValuesAfterWrongAnswer()
            }
        } else if (formOfVerb == 3) {
            if (result == getCurrentVerb().thirdForm) {
                changeValuesAfterRightAnswer()
            } else {
                changeValuesAfterWrongAnswer()
            }
        }
        incrementVerbIndex()
    }

    private fun changeValuesAfterRightAnswer() {
        viewState.displayIfAnswerCorrect()
        viewState.initRealm()
        RealmVerbGateway().changeAmountOfAnswers(getCurrentVerb())
        totalAmountOfCorrectAnswers++
        displayProgress()
    }

    private fun changeValuesAfterWrongAnswer() {
        viewState.displayIfAnswerWrong(getCurrentVerb())
        viewState.initRealm()
        RealmVerbGateway().changeAmountOfMistakes(getCurrentVerb())
    }

    private fun checkIsVerbsAreAnswered() {
        if (getCurrentVerb().amountOfCorrectAnswers == AMOUNT_OF_ANSWERS_TO_COMPLETE) {
            var isCompleted = true
            for (verb in verbs) {
                if (verb.amountOfCorrectAnswers != AMOUNT_OF_ANSWERS_TO_COMPLETE) {
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
        progressPercent = 100 / (verbs.size * AMOUNT_OF_ANSWERS_TO_COMPLETE).toFloat() * totalAmountOfCorrectAnswers.toFloat()
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
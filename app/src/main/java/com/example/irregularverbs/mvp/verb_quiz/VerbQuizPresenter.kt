package com.example.irregularverbs.mvp.verb_quiz

import android.util.Log
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
    //TODO DELETE UNNECESSARY TYPES - FIXED

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        initVerbs()
        getNewVerb()
        loadCurrentProgress()
    }

    fun loadIrregularVerbs(level: Int) {
        setLevel(level)
    }

    private fun setLevel(level: Int) {
        this.level = level
    }

    private fun initVerbs() {
        viewState.initRealm()
        verbs = RealmVerbGateway().loadVerbs(level)
        verbs.shuffle()
    }

    fun getNewVerb() {
        formOfVerb = Random.nextInt(2, 4)
        val currentVerb = getCurrentVerb()
        viewState.displayNewVerb(currentVerb, formOfVerb)

        checkIsVerbsAreAnswered(currentVerb)
    }

    private fun loadCurrentProgress() {
        verbs.forEach { verb ->
            totalAmountOfCorrectAnswers += verb.amountOfCorrectAnswers
        }
        displayProgress()
    }

    fun checkVerbIsCorrectly(result: String) {
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

    private fun checkIsVerbsAreAnswered(currentVerb: Verb) {
        if (currentVerb.amountOfCorrectAnswers == AMOUNT_OF_ANSWERS_TO_COMPLETE) {
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
        val progressPercent = (100f / (verbs.size * AMOUNT_OF_ANSWERS_TO_COMPLETE)) * totalAmountOfCorrectAnswers
        Log.d(TAG, "displayProgress: $progressPercent")
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


    private val TAG = "VerbQuizPresenter"
    private fun getCurrentVerb() = verbs[currentVerbIndex]
}
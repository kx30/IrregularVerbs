package com.example.irregularverbs.mvp.base

import android.view.View
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.example.irregularverbs.gateway.realm.RealmVerbGateway
import com.example.irregularverbs.mvp.adapter.VerbAdapter
import com.example.irregularverbs.mvp.models.Verb

open class BasePresenter<T : MvpView> : MvpPresenter<T>() {

    private var verbList = ArrayList<Verb>()
    private var tooBadVerbList = ArrayList<Verb>()
    private var soSoVerbList = ArrayList<Verb>()
    private var exactlyKnownVerbList = ArrayList<Verb>()
    companion object {
        const val PRESENTER_TAG = "BasePresenter"
    }


    fun getTypeOfSkill() {
        loadVerbs()
        RealmVerbGateway.verbList.forEach { verb ->
            if (verb.amountOfCorrectAnswers < 3 && verb.amountOfMistakes > 4) {
                tooBadVerbList.add(verb)
            } else if (verb.amountOfCorrectAnswers in 3..5 && verb.amountOfMistakes > 2) {
                soSoVerbList.add(verb)
            } else if (verb.amountOfCorrectAnswers > 3 && verb.amountOfMistakes < 3
                || verb.amountOfCorrectAnswers == Verb.AMOUNT_OF_ANSWERS_TO_COMPLETE
            ) {
                exactlyKnownVerbList.add(verb)
            }
        }
        if (tooBadVerbList.isNotEmpty()) {
            (viewState as BaseView).unlockResultButton(1) //TODO
        }
        if (soSoVerbList.isNotEmpty()) {
            (viewState as BaseView).initSoSoButton()
        }
        if (exactlyKnownVerbList.isNotEmpty()) {
            (viewState as BaseView).initExactlyKnownButton()
        }
    }

    private fun loadVerbs() {
        verbList = RealmVerbGateway().loadVerbs(null)
    }
}
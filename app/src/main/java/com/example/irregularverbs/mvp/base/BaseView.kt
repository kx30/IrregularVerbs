package com.example.irregularverbs.mvp.base

import com.arellomobile.mvp.MvpView

interface BaseView: MvpView { //TODO STRATEGY
    fun initTooBadButton()
    fun initSoSoButton()
    fun initExactlyKnownButton()
}
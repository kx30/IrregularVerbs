package com.example.irregularverbs.mvp.base

import com.arellomobile.mvp.MvpView

interface BaseView: MvpView {
    fun initTooBadButton()
    fun initSoSoButton()
    fun initExactlyKnownButton()
}
package com.example.irregularverbs.mvp.utils

import android.view.View

fun View.visible(state: Boolean) {
    if (state) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.INVISIBLE
    }
}
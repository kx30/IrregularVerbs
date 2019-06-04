package com.example.irregularverbs.mvp.utils

import android.support.v7.widget.SearchView

open class CustomOnQueryTextListener: SearchView.OnQueryTextListener {
    override fun onQueryTextSubmit(p0: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}
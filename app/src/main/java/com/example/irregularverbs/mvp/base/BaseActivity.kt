package com.example.irregularverbs.mvp.base

import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.irregularverbs.R

open class BaseActivity: MvpAppCompatActivity() { //TODO FIX YELLOW WARNING - FIXED

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    protected fun initActionBar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        with (supportActionBar) {
            title = ""
            this?.setDisplayHomeAsUpEnabled(true)
            this?.setDisplayShowHomeEnabled(true)
        }//TODO U CAN USE OPERATOR 'with(supportActionBar)' - FIXED
//        supportActionBar?.title = ""
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}
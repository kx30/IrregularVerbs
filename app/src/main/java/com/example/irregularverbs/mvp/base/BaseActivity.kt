package com.example.irregularverbs.mvp.base

import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.irregularverbs.R

open class BaseActivity: MvpAppCompatActivity() {

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    protected fun initActionBar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}
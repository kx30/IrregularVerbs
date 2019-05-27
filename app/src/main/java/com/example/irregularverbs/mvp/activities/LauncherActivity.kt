package com.example.irregularverbs.mvp.activities

import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.presenters.LauncherPresenter
import com.example.irregularverbs.mvp.views.LauncherView
import kotlinx.android.synthetic.main.activity_launcher.*

class LauncherActivity : MvpAppCompatActivity(), LauncherView {

    @InjectPresenter
    lateinit var launcherPresenter: LauncherPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        setListeners()
    }

    private fun setListeners() {
        examButton.setOnClickListener {
            launcherPresenter.startChooseComplexityExamActivity()
        }
        listButton.setOnClickListener {
            launcherPresenter.startVerbsListActivity()
        }
    }

    override fun startChooseComplexityExamActivity() {
        startActivity(Intent(this, ChooseComplexityExamActivity::class.java))
    }

    override fun startVerbsListActivity() {
        startActivity(Intent(this, VerbListActivity::class.java))
    }
}

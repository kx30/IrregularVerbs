package com.example.irregularverbs.mvp.activities

import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.irregularverbs.R
import com.example.irregularverbs.gateway.local.LocalVerbGateway
import com.example.irregularverbs.mvp.presenters.LauncherPresenter
import com.example.irregularverbs.mvp.views.LauncherView
import kotlinx.android.synthetic.main.activity_launcher.*

class LauncherActivity : MvpAppCompatActivity(), LauncherView {

    @InjectPresenter
    lateinit var launcherPresenter: LauncherPresenter

    private val TAG = "LauncherActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        setListeners()
        LocalVerbGateway().loadVerbs(this, null)
    }

    private fun setListeners() {
        examButton.setOnClickListener {
            launcherPresenter.startChooseLevelExamActivity()
        }
        listButton.setOnClickListener {
            launcherPresenter.startVerbsListActivity()
        }
        flashcardButton.setOnClickListener {
            launcherPresenter.startChooseLevelFlashcardActivity()
        }
    }

    override fun startChooseLevelExamActivity() {
        startActivity(Intent(this, ChooseLevelExamActivity::class.java))
    }

    override fun startVerbsListActivity() {
        startActivity(Intent(this, VerbListActivity::class.java))
    }

    override fun startChooseLevelFlashcardActivity() {
        startActivity(Intent(this, ChooseLevelFlashcardActivity::class.java))
    }
}

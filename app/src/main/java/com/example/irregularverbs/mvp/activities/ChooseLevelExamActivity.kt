package com.example.irregularverbs.mvp.activities

import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.presenters.ChooseLevelExamPresenter
import com.example.irregularverbs.mvp.views.ChooseLevelExamView
import kotlinx.android.synthetic.main.activity_choose_complexity_exam.*

class ChooseLevelExamActivity : MvpAppCompatActivity(), ChooseLevelExamView {

    @InjectPresenter
    lateinit var chooseLevelExamPresenter: ChooseLevelExamPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_complexity_exam)
        setListeners()
    }

    private fun setListeners() {
        firstLevelButton.setOnClickListener {
            chooseLevelExamPresenter.startVerbQuizActivityButtonWasClicked(1)
        }
        secondLevelButton.setOnClickListener {
            chooseLevelExamPresenter.startVerbQuizActivityButtonWasClicked(2)
        }
        thirdLevelButton.setOnClickListener {
            chooseLevelExamPresenter.startVerbQuizActivityButtonWasClicked(3)
        }
        fourthLevelButton.setOnClickListener {
            chooseLevelExamPresenter.startVerbQuizActivityButtonWasClicked(4)
        }
        fifthLevelButton.setOnClickListener {
            chooseLevelExamPresenter.startVerbQuizActivityButtonWasClicked(5)
        }
    }

    override fun startVerbQuizActivity(level: Int) {
        startActivity(Intent(this, VerbQuizActivity::class.java).putExtra("Level", level))
    }
}
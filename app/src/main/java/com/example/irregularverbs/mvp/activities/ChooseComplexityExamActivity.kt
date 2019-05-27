package com.example.irregularverbs.mvp.activities

import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.presenters.ChooseComplexityExamPresenter
import com.example.irregularverbs.mvp.views.ChooseComplexityExamView
import kotlinx.android.synthetic.main.activity_choose_complexity_exam.*

class ChooseComplexityExamActivity : MvpAppCompatActivity(), ChooseComplexityExamView {

    @InjectPresenter
    lateinit var chooseComplexityExamPresenter: ChooseComplexityExamPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_complexity_exam)
        setListeners()
    }

    private fun setListeners() {
        firstLevelButton.setOnClickListener {
            chooseComplexityExamPresenter.startVerbQuizActivityButtonWasClicked(1)
        }
        secondLevelButton.setOnClickListener {
            chooseComplexityExamPresenter.startVerbQuizActivityButtonWasClicked(2)
        }
        thirdLevelButton.setOnClickListener {
            chooseComplexityExamPresenter.startVerbQuizActivityButtonWasClicked(3)
        }
        fourthLevelButton.setOnClickListener {
            chooseComplexityExamPresenter.startVerbQuizActivityButtonWasClicked(4)
        }
        fifthLevelButton.setOnClickListener {
            chooseComplexityExamPresenter.startVerbQuizActivityButtonWasClicked(5)
        }
    }

    override fun startVerbQuizActivity(complexity: Int) {
        startActivity(Intent(this, VerbQuizActivity::class.java).putExtra("Complexity", complexity))
    }
}

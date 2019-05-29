package com.example.irregularverbs.mvp.activities

import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.presenters.ChooseLevelFlashcardPresenter
import com.example.irregularverbs.mvp.views.ChooseLevelFlashcardView
import kotlinx.android.synthetic.main.activity_choose_complexity_exam.*

class ChooseLevelFlashcardActivity : MvpAppCompatActivity(), ChooseLevelFlashcardView {
    @InjectPresenter
    lateinit var chooseLevelFlashcardPresenter: ChooseLevelFlashcardPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_level_flashcard)
        setListeners()
    }

    private fun setListeners() {
        firstLevelButton.setOnClickListener {
            chooseLevelFlashcardPresenter.startVerbQuizActivityButtonWasClicked(1)
        }
        secondLevelButton.setOnClickListener {
            chooseLevelFlashcardPresenter.startVerbQuizActivityButtonWasClicked(2)
        }
        thirdLevelButton.setOnClickListener {
            chooseLevelFlashcardPresenter.startVerbQuizActivityButtonWasClicked(3)
        }
        fourthLevelButton.setOnClickListener {
            chooseLevelFlashcardPresenter.startVerbQuizActivityButtonWasClicked(4)
        }
        fifthLevelButton.setOnClickListener {
            chooseLevelFlashcardPresenter.startVerbQuizActivityButtonWasClicked(5)
        }
    }

    override fun startFlashCardActivity(level: Int) {
        startActivity(Intent(this, FlashcardActivity::class.java).putExtra("Level", level))
    }
}

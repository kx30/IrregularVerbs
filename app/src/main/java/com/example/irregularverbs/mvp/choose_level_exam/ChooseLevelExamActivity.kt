package com.example.irregularverbs.mvp.choose_level_exam

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.verb_quiz.VerbQuizActivity
import kotlinx.android.synthetic.main.activity_choose_complexity_exam.*

class ChooseLevelExamActivity : MvpAppCompatActivity(),
    ChooseLevelExamView {

    @InjectPresenter
    lateinit var chooseLevelExamPresenter: ChooseLevelExamPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_complexity_exam)
        chooseLevelExamPresenter.initPresenter()
        setListeners()
    }

    override fun onRestart() {
        super.onRestart()
        chooseLevelExamPresenter.initPresenter()
        setButtonBackgrounds()
        setListeners()
    }

    private fun setButtonBackgrounds() {
        firstLevelButton.setBackgroundResource(R.drawable.base_button_background)
        secondLevelButton.setBackgroundResource(R.drawable.base_button_background)
        thirdLevelButton.setBackgroundResource(R.drawable.base_button_background)
        fourthLevelButton.setBackgroundResource(R.drawable.base_button_background)
        fifthLevelButton.setBackgroundResource(R.drawable.base_button_background)
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

    override fun firstLevelIsCompleted() {
        firstLevelButton.text = "Completed"
        firstLevelButton.setOnClickListener {
            buildAlertDialog(1)
        }
    }

    override fun secondLevelIsCompleted() {
        secondLevelButton.setBackgroundResource(R.drawable.completed_button)
        secondLevelButton.text = "Completed"
        secondLevelButton.setOnClickListener {
            buildAlertDialog(2)
        }
    }

    override fun thirdLevelIsCompleted() {
        thirdLevelButton.setBackgroundResource(R.drawable.completed_button)
        thirdLevelButton.text = "Completed"
        thirdLevelButton.setOnClickListener {
            buildAlertDialog(3)
        }
    }

    override fun fourthLevelIsCompleted() {
        fourthLevelButton.setBackgroundResource(R.drawable.completed_button)
        fourthLevelButton.text = "Completed"
        fourthLevelButton.setOnClickListener {
            buildAlertDialog(4)
        }
    }

    override fun fifthLevelIsCompleted() {
        fifthLevelButton.setBackgroundResource(R.drawable.completed_button)
        fifthLevelButton.text = "Completed"
        fifthLevelButton.setOnClickListener {
            buildAlertDialog(5)
        }
    }

    private fun buildAlertDialog(level: Int) {
        AlertDialog.Builder(this)
            .setTitle("Warning")
            .setMessage("Are you sure want to delete all of your progress this level?")
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
                chooseLevelExamPresenter.deleteProgressOfLevel(level)
                chooseLevelExamPresenter.startVerbQuizActivityButtonWasClicked(level)
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.cancel()
            }
            .show()
    }

    override fun startVerbQuizActivity(level: Int) {
        startActivity(Intent(this, VerbQuizActivity::class.java).putExtra(getString(R.string.TAG_LEVEL), level))
    }
}
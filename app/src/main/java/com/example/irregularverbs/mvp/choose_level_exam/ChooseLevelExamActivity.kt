package com.example.irregularverbs.mvp.choose_level_exam

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.base.BaseActivity
import com.example.irregularverbs.mvp.verb_quiz.VerbQuizActivity
import kotlinx.android.synthetic.main.activity_choose_complexity_exam.*

class ChooseLevelExamActivity : BaseActivity(), ChooseLevelExamView {

    @InjectPresenter
    lateinit var chooseLevelExamPresenter: ChooseLevelExamPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_complexity_exam)
        chooseLevelExamPresenter.initPresenter()
        setListeners()
        initActionBar()
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
        changeButtonConditionIfCategoryIsCompleted(firstLevelButton, 1)
    }

    override fun secondLevelIsCompleted() {
        changeButtonConditionIfCategoryIsCompleted(secondLevelButton, 2)
    }

    override fun thirdLevelIsCompleted() {
        changeButtonConditionIfCategoryIsCompleted(thirdLevelButton, 3)
    }

    override fun fourthLevelIsCompleted() {
        changeButtonConditionIfCategoryIsCompleted(fourthLevelButton, 4)
    }

    override fun fifthLevelIsCompleted() {
        changeButtonConditionIfCategoryIsCompleted(fifthLevelButton, 5)
    }

    private fun changeButtonConditionIfCategoryIsCompleted(button: Button, category: Int) {
        val alertDialog = buildAlertDialog(category)
        button.setBackgroundResource(R.drawable.completed_button)
        button.text = getString(R.string.completed)
        button.setOnClickListener {
            alertDialog.show()
        }
    }

    override fun startVerbQuizActivity(level: Int) {
        startActivity(Intent(this, VerbQuizActivity::class.java).putExtra(getString(R.string.TAG_LEVEL), level))
    }

    private fun buildAlertDialog(category: Int): AlertDialog.Builder {
        return AlertDialog.Builder(this)
            .setTitle("Warning")
            .setMessage("Are you sure want to delete all of your progress this level?")
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
                chooseLevelExamPresenter.deleteProgressOfLevel(category)
                chooseLevelExamPresenter.startVerbQuizActivityButtonWasClicked(category)
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.cancel()
            }
    }
}
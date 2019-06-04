package com.example.irregularverbs.mvp.progress

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.base.BaseActivity
import com.example.irregularverbs.mvp.verb_list.VerbListActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_progress.*
import java.text.DecimalFormat

class ProgressActivity : BaseActivity(), ProgressView {

    @InjectPresenter
    lateinit var progressPresenter: ProgressPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)
        progressPresenter.setCurrentProgress()
        setListeners()
        initActionBar()
        initRealm()
        progressPresenter.getTypeOfSkill()
    }

    override fun startVerbListActivity(level: Int?) {
        startActivity(Intent(this, VerbListActivity::class.java).putExtra(getString(R.string.TAG_LEVEL), level))
    }

    override fun initRealm() {
        Realm.init(this)
    }

    private fun setListeners() {
        resetProgressButton.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Warning")
                .setMessage("Are you sure want to delete all of your progress?")
                .setPositiveButton("Yes") { _, _ ->
                    progressPresenter.resetAllProgress()
                    finish()
                }
                .setNegativeButton("No") { dialog, _ ->
                    dialog.cancel()
                }
                .show()
        }
        tooBadButton.setOnClickListener {
            showAlertDialog()
        }
        soSoButton.setOnClickListener {
            showAlertDialog()
        }
        exactlyKnownButton.setOnClickListener {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.app_name))
            .setMessage("You have no verbs here")
            .setPositiveButton("Ok") { dialog, _ ->
                dialog.cancel()
            }
            .show()
    }

    @SuppressLint("SetTextI18n")
    override fun setFirstLevelProgressTextView(progressPercent: Float) {
        firstLevelProgressPercentTextView.text = "${DecimalFormat("#.#").format(progressPercent)}%"
    }

    @SuppressLint("SetTextI18n")
    override fun setSecondLevelProgressTextView(progressPercent: Float) {
        secondLevelProgressPercentTextView.text = "${DecimalFormat("#.#").format(progressPercent)}%"
    }

    @SuppressLint("SetTextI18n")
    override fun setThirdLevelProgressTextView(progressPercent: Float) {
        thirdLevelProgressPercentTextView.text = "${DecimalFormat("#.#").format(progressPercent)}%"
    }

    @SuppressLint("SetTextI18n")
    override fun setFourthLevelProgressTextView(progressPercent: Float) {
        fourthLevelProgressPercentTextView.text = "${DecimalFormat("#.#").format(progressPercent)}%"
    }

    @SuppressLint("SetTextI18n")
    override fun setFifthLevelProgressTextView(progressPercent: Float) {
        fifthLevelProgressPercentTextView.text = "${DecimalFormat("#.#").format(progressPercent)}%"
    }

    @SuppressLint("SetTextI18n")
    override fun setAmountOfAnswersTextView(rightAnswers: String, wrongAnswers: String) {
        amountOfAnswersTextView.text = "$rightAnswers correct, $wrongAnswers wrong answers"
    }

    @SuppressLint("SetTextI18n")
    override fun setTooBadTextView(amountOfTooBadVerbs: String) {
        tooBadTextView.text = "${resources.getString(R.string.too_bad)} $amountOfTooBadVerbs verbs"
    }

    @SuppressLint("SetTextI18n")
    override fun setSoSoTextView(amountOfSoSoVerbs: String) {
        soSoTextView.text = "${resources.getString(R.string.so_so)} $amountOfSoSoVerbs irregular verbs"
    }

    @SuppressLint("SetTextI18n")
    override fun setExactlyKnownTextView(amountOfExactlyKnownTextView: String) {
        exactlyKnownTextView.text =
            "${resources.getString(R.string.exactly_known)} $amountOfExactlyKnownTextView irregular verbs"
    }

    override fun initTooBadButton() {
        tooBadButton.setBackgroundResource(R.drawable.base_button_background)
        tooBadButton.setOnClickListener {
            progressPresenter.startVerbListActivity(1)
        }
    }

    override fun initSoSoButton() {
        soSoButton.setBackgroundResource(R.drawable.base_button_background)
        soSoButton.setOnClickListener {
            progressPresenter.startVerbListActivity(2)
        }
    }

    override fun initExactlyKnownButton() {
        exactlyKnownButton.setBackgroundResource(R.drawable.base_button_background)
        exactlyKnownButton.setOnClickListener {
            progressPresenter.startVerbListActivity(3)
        }
    }
}

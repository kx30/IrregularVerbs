package com.example.irregularverbs.mvp.progress

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
        progressPresenter.checkConditionAndUnlockButton()
    }

    override fun startVerbListActivity(level: Int?) {
        val intent = Intent(this, VerbListActivity::class.java)
        val tagLevel = getString(R.string.TAG_LEVEL)
        startActivity(intent.putExtra(tagLevel, level))
    }

    override fun initRealm() {
        Realm.init(this)
    }

    //TODO use your brain - FIXED(??????)

    private fun setListeners() {
        val deleteAllProgressDialog = buildDeleteAllProgressAlertDialog()
        val noVerbsHereDialog = buildNoVerbsHereAlertDialog()

        resetProgressButton.setOnClickListener {
            deleteAllProgressDialog.show()
        }
        tooBadButton.setOnClickListener {
            noVerbsHereDialog.show()
        }
        soSoButton.setOnClickListener {
            noVerbsHereDialog.show()
        }
        exactlyKnownButton.setOnClickListener {
            noVerbsHereDialog.show()
        }
    }

    private fun buildDeleteAllProgressAlertDialog(): AlertDialog.Builder {
        return AlertDialog
            .Builder(this)
            .setTitle("Warning")
            .setMessage("Are you sure want to delete all of your progress?")
            .setPositiveButton("Yes") { _, _ ->
                progressPresenter.resetAllProgress()
                finish()
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.cancel()
            }
    }

    private fun buildNoVerbsHereAlertDialog(): AlertDialog.Builder {
        return AlertDialog.Builder(this)
            .setTitle(getString(R.string.app_name))
            .setMessage("You have no verbs here")
            .setPositiveButton("Ok") { dialog, _ ->
                dialog.cancel()
            }
    }

    override fun setFirstLevelProgressTextView(progressPercent: Float) {
        val formattedProgress = "${DecimalFormat("#.#").format(progressPercent)}%"
        firstLevelProgressPercentTextView.text = formattedProgress
    }

    override fun setSecondLevelProgressTextView(progressPercent: Float) {
        val formattedProgress = "${DecimalFormat("#.#").format(progressPercent)}%"
        secondLevelProgressPercentTextView.text = formattedProgress
    }

    override fun setThirdLevelProgressTextView(progressPercent: Float) {
        val formattedProgress = "${DecimalFormat("#.#").format(progressPercent)}%"
        thirdLevelProgressPercentTextView.text = formattedProgress
    }

    override fun setFourthLevelProgressTextView(progressPercent: Float) {
        val formattedProgress = "${DecimalFormat("#.#").format(progressPercent)}%"
        fourthLevelProgressPercentTextView.text = formattedProgress
    }

    override fun setFifthLevelProgressTextView(progressPercent: Float) {
        val formattedProgress = "${DecimalFormat("#.#").format(progressPercent)}%"
        fifthLevelProgressPercentTextView.text = formattedProgress
    }

    override fun setAmountOfAnswersTextView(rightAnswers: String, wrongAnswers: String) {
        val text = "$rightAnswers correct, $wrongAnswers wrong answers"
        amountOfAnswersTextView.text = text
    }

    override fun setTooBadTextView(amountOfTooBadVerbs: String) {
        val text = "${resources.getString(R.string.too_bad)} $amountOfTooBadVerbs verbs"
        tooBadTextView.text = text
    }

    override fun setSoSoTextView(amountOfSoSoVerbs: String) {
        val text = "${resources.getString(R.string.so_so)} $amountOfSoSoVerbs irregular verbs"
        soSoTextView.text = text
    }

    override fun setExactlyKnownTextView(amountOfExactlyKnownTextView: String) {
        val text = "${resources.getString(R.string.exactly_known)} $amountOfExactlyKnownTextView irregular verbs"
        exactlyKnownTextView.text = text
    }

    override fun unlockResultButton(category: Int) {
        val backgroundRes = R.drawable.base_button_background
        val button = when (category) {
            1 -> tooBadButton
            2 -> soSoButton
            else -> exactlyKnownButton
        }
        button.setBackgroundResource(backgroundRes)
        button.setOnClickListener {
            progressPresenter.startVerbListActivity(category)
        }
    }
}

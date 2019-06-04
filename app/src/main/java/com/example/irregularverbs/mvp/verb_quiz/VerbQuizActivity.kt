package com.example.irregularverbs.mvp.verb_quiz

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.base.BaseActivity
import com.example.irregularverbs.mvp.models.Verb
import com.example.irregularverbs.mvp.utils.visible
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_verb_quiz.*
import java.text.DecimalFormat
import java.util.*
import kotlin.math.roundToInt


class VerbQuizActivity : BaseActivity(), VerbQuizView {

    @InjectPresenter
    lateinit var verbQuizPresenter: VerbQuizPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verb_quiz)
        initActionBar()
        initPresenter()
        setListeners()
    }

    private fun initPresenter() {
        val level = intent.getIntExtra(getString(R.string.TAG_LEVEL), 1)
        verbQuizPresenter.loadIrregularVerbs(level)
    }

    private fun setListeners() {
        okButton.setOnClickListener {
            if (currentVerbEditText.text.isNotEmpty()) { //TODO isNotBlank
                with(verbQuizPresenter) {
                    checkVerbIsCorrectly(currentVerbEditText.text.toString().toLowerCase())
                    getNewVerb()
                }
                currentVerbEditText.text.clear()
            }
        }
    }

    override fun displayNewVerb(verb: Verb, formOfVerb: Int) {
        currentVerbTextView.text = verb.firstForm
        translateTextView.text = verb.translate
        if (formOfVerb == 2) {
            currentFormOfVerbTextView.text = getString(R.string.v2)
        } else {
            currentFormOfVerbTextView.text = "v3" //TODO FIX YELLOW WARNING
        }
    }

    override fun displayIfAnswerCorrect() {
        setInvisibleTextViews()
        okButton.setBackgroundResource(R.drawable.green_circle_button)

        Timer().schedule(object : TimerTask() {
            override fun run() {
//                okButton.post {
//                    okButton.setBackgroundResource(R.drawable.circle_button)
//                }
                runOnUiThread {
                    okButton.setBackgroundResource(R.drawable.circle_button)
                }
            }
        }, 1000)

    }

    override fun displayIfAnswerWrong(verb: Verb) {
        setVisibleTextViews()
        crossedWrongWordTextView.text = currentVerbEditText.text
        firstFormOfVerbTextView.text = verb.firstForm
        secondFormOfVerbTextView.text = verb.secondForm
        thirdFormOfVerbTextView.text = verb.thirdForm
    }

    override fun initRealm() {
        Realm.init(this)
    }

    override fun displayProgress(progressPercent: Float) {
        progressBar.progress = progressPercent.roundToInt()
        currentProgressInPercent.text = "${DecimalFormat("#.#").format(progressPercent)}%"
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun finishActivityIfCompleted() {
        finish()
    }

    private fun setVisibleTextViews() {
        crossedWrongWordTextView.visible(true)
        crossedWrongWordTextView.visibility = View.VISIBLE
        wrongAnswerTextView.visibility = View.VISIBLE
        firstFormOfVerbTextView.visibility = View.VISIBLE
        secondFormOfVerbTextView.visibility = View.VISIBLE
        thirdFormOfVerbTextView.visibility = View.VISIBLE
    }

    private fun setInvisibleTextViews() {
        crossedWrongWordTextView.visible(false)
        crossedWrongWordTextView.visibility = View.INVISIBLE
        wrongAnswerTextView.visibility = View.INVISIBLE
        firstFormOfVerbTextView.visibility = View.INVISIBLE
        secondFormOfVerbTextView.visibility = View.INVISIBLE
        thirdFormOfVerbTextView.visibility = View.INVISIBLE
    }
}

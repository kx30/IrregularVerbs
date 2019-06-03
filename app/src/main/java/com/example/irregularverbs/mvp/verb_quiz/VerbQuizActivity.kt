package com.example.irregularverbs.mvp.verb_quiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.models.Verb
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_verb_quiz.*
import java.text.DecimalFormat
import java.util.*
import kotlin.math.roundToInt

class VerbQuizActivity : MvpAppCompatActivity(), VerbQuizView {

    @InjectPresenter
    lateinit var verbQuizPresenter: VerbQuizPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verb_quiz)
        initPresenter()
        setListeners()
    }

    private fun initPresenter() {
        val level = intent.getIntExtra(getString(R.string.TAG_LEVEL), 1)
        verbQuizPresenter.loadIrregularVerbs(level)
    }

    private fun setListeners() {
        okButton.setOnClickListener {
            verbQuizPresenter.okButtonWasClicked(currentVerbEditText.text.toString().toLowerCase())
            currentVerbEditText.text.clear()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun displayNewVerb(verb: Verb, formOfVerb: Int) {
        currentVerbTextView.text = verb.firstForm
        translateTextView.text = verb.translate
        if (formOfVerb == 2) {
            currentFormOfVerbTextView.text = "v2"
        } else {
            currentFormOfVerbTextView.text = "v3"
        }
    }

    override fun displayIfAnswerCorrect() {
        setInvisibleTextViews()
        okButton.setBackgroundResource(R.drawable.green_circle_button)
        Timer().schedule(object: TimerTask() {
            override fun run() {
                okButton.setBackgroundResource(R.drawable.circle_button)
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

    @SuppressLint("SetTextI18n")
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
        crossedWrongWordTextView.visibility = View.VISIBLE
        wrongAnswerTextView.visibility = View.VISIBLE
        firstFormOfVerbTextView.visibility = View.VISIBLE
        secondFormOfVerbTextView.visibility = View.VISIBLE
        thirdFormOfVerbTextView.visibility = View.VISIBLE
    }

    private fun setInvisibleTextViews() {
        crossedWrongWordTextView.visibility = View.INVISIBLE
        wrongAnswerTextView.visibility = View.INVISIBLE
        firstFormOfVerbTextView.visibility = View.INVISIBLE
        secondFormOfVerbTextView.visibility = View.INVISIBLE
        thirdFormOfVerbTextView.visibility = View.INVISIBLE
    }
}

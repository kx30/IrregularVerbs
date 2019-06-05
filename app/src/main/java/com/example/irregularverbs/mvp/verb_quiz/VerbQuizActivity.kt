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

    //TODO isNotBlank - FIXED
    private fun setListeners() {
        okButton.setOnClickListener {
            if (currentVerbEditText.text.isNotBlank()) {
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
            currentFormOfVerbTextView.text = getString(R.string.v3)
        }
    }

    override fun displayIfAnswerCorrect() {
        setInvisibleTextViews()
        okButton.setBackgroundResource(R.drawable.green_circle_button)

        // TODO CHECK
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

    //TODO FIX YELLOW THINGS - FIXED
    override fun displayProgress(progressPercent: Float) {
        progressBar.progress = progressPercent.toInt()
        val progressInPercent = "${DecimalFormat("#.#").format(progressPercent)}%"
        currentProgressInPercent.text = progressInPercent
    }


    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun finishActivityIfCompleted() {
        finish()
    }

    private fun setVisibleTextViews() {
        crossedWrongWordTextView.visible(true)
        wrongAnswerTextView.visible(true)
        firstFormOfVerbTextView.visible(true)
        secondFormOfVerbTextView.visible(true)
        thirdFormOfVerbTextView.visible(true)
    }

    private fun setInvisibleTextViews() {
        crossedWrongWordTextView.visible(false)
        wrongAnswerTextView.visible(false)
        firstFormOfVerbTextView.visible(false)
        secondFormOfVerbTextView.visible(false)
        thirdFormOfVerbTextView.visible(false)
    }
}

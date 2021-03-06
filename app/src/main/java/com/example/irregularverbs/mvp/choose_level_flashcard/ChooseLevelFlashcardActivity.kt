package com.example.irregularverbs.mvp.choose_level_flashcard

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.base.BaseActivity
import com.example.irregularverbs.mvp.flashcard.FlashcardActivity
import com.example.irregularverbs.mvp.verb_list.VerbListActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_choose_level_flashcard.*

class ChooseLevelFlashcardActivity : BaseActivity(), ChooseLevelFlashcardView {

    @InjectPresenter
    lateinit var chooseLevelFlashcardPresenter: ChooseLevelFlashcardPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_level_flashcard)
        setListeners()
        initRealm()
        initActionBar() //TODO firstViewAttach - FIXED
    }

    private fun setListeners() {
        firstLevelButton.setOnClickListener {
            chooseLevelFlashcardPresenter.startFlashCardActivity(1)
        }
        secondLevelButton.setOnClickListener {
            chooseLevelFlashcardPresenter.startFlashCardActivity(2)
        }
        thirdLevelButton.setOnClickListener {
            chooseLevelFlashcardPresenter.startFlashCardActivity(3)
        }
        fourthLevelButton.setOnClickListener {
            chooseLevelFlashcardPresenter.startFlashCardActivity(4)
        }
        fifthLevelButton.setOnClickListener {
            chooseLevelFlashcardPresenter.startFlashCardActivity(5)
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

    override fun initRealm() {
        Realm.init(this)
    }

    override fun startFlashCardActivity(level: Int) {
        startActivity(Intent(this, FlashcardActivity::class.java).putExtra(getString(R.string.TAG_LEVEL), level))
    }

    override fun startVerbListActivity(level: Int?) {
        startActivity(Intent(this, VerbListActivity::class.java).putExtra(getString(R.string.TAG_LEVEL), level))
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
            chooseLevelFlashcardPresenter.startVerbListActivity(category)
        }
    }
}

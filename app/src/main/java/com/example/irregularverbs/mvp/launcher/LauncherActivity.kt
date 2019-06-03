package com.example.irregularverbs.mvp.launcher

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.verb_list.VerbListActivity
import com.example.irregularverbs.mvp.progress.ProgressActivity
import com.example.irregularverbs.mvp.choose_level_exam.ChooseLevelExamActivity
import com.example.irregularverbs.mvp.choose_level_flashcard.ChooseLevelFlashcardActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_launcher.*

class LauncherActivity : MvpAppCompatActivity(), LauncherView {

    private val TAG = "LauncherActivity"
    @InjectPresenter
    lateinit var launcherPresenter: LauncherPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        setListeners()
        Realm.init(this)
        saveVerbsIfFirstLaunch()
        launcherPresenter.loadVerbs()
    }

    override fun saveVerbsIfFirstLaunch() {
        val isSkipped = getSharedPreferences("value", Context.MODE_PRIVATE).getBoolean("isSkipped", false)
        if (!isSkipped) {
            launcherPresenter.saveVerbsInRealm()
            val sharedPreferences = getSharedPreferences("value", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("isSkipped", true)
            editor.apply()
        }
    }

    private fun setListeners() {
        examButton.setOnClickListener {
            launcherPresenter.startChooseLevelExamActivity()
        }
        listButton.setOnClickListener {
            launcherPresenter.startVerbsListActivity()
        }
        flashcardButton.setOnClickListener {
            launcherPresenter.startChooseLevelFlashcardActivity()
        }
        progressButton.setOnClickListener {
            launcherPresenter.startProgressActivity()
        }
    }

    override fun startChooseLevelExamActivity() {
        startActivity(Intent(this, ChooseLevelExamActivity::class.java))
    }

    override fun startVerbsListActivity() {
        startActivity(Intent(this, VerbListActivity::class.java))
    }

    override fun startChooseLevelFlashcardActivity() {
        startActivity(Intent(this, ChooseLevelFlashcardActivity::class.java))
    }

    override fun startProgressActivity() {
        startActivity(Intent(this, ProgressActivity::class.java))
    }
}

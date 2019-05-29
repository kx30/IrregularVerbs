package com.example.irregularverbs.mvp.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.adapter.FlashcardAdapter
import com.example.irregularverbs.mvp.models.Verb
import com.example.irregularverbs.mvp.presenters.FlashcardPresenter
import com.example.irregularverbs.mvp.views.FlashcardView
import kotlinx.android.synthetic.main.activity_flashcard.*
import kotlinx.android.synthetic.main.activity_verbs_list.*

class FlashcardActivity : MvpAppCompatActivity(), FlashcardView {
    @InjectPresenter
    lateinit var flashcardPresenter: FlashcardPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard)
        val level = intent.getIntExtra("Level", 1)
        flashcardPresenter.setLevel(level)
        flashcardPresenter.getVerbList()
    }

    override fun initRecyclerView(verbList: ArrayList<Verb>) {
        flashcardRecyclerView.layoutManager = LinearLayoutManager(this)
        flashcardRecyclerView.adapter = FlashcardAdapter(verbList)
    }
}

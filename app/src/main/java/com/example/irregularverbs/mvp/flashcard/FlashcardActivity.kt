package com.example.irregularverbs.mvp.flashcard

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.adapter.FlashcardAdapter
import com.example.irregularverbs.mvp.models.Verb
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_flashcard.*

class FlashcardActivity : MvpAppCompatActivity(), FlashcardView {

    @InjectPresenter
    lateinit var flashcardPresenter: FlashcardPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard)
        val level = intent.getIntExtra(getString(R.string.TAG_LEVEL), 1)
        flashcardPresenter.setLevel(level)
        flashcardPresenter.getVerbList()
    }

    override fun initRecyclerView(verbList: ArrayList<Verb>) {
        flashcardRecyclerView.layoutManager = LinearLayoutManager(this)
        flashcardRecyclerView.adapter = FlashcardAdapter(verbList)
    }

    override fun initRealm() {
        Realm.init(this)
    }
}

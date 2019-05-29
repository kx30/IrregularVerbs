package com.example.irregularverbs.mvp.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.adapter.VerbAdapter
import com.example.irregularverbs.mvp.models.Verb
import com.example.irregularverbs.mvp.presenters.VerbListPresenter
import com.example.irregularverbs.mvp.views.VerbListView
import kotlinx.android.synthetic.main.activity_verbs_list.*

class VerbListActivity : MvpAppCompatActivity(), VerbListView {
    @InjectPresenter
    lateinit var verbListPresenter: VerbListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verbs_list)
    }

    override fun initRecyclerView(verbList: ArrayList<Verb>) {
        verbListRecyclerView.layoutManager = LinearLayoutManager(this)
        verbListRecyclerView.adapter = VerbAdapter(verbList)
    }
}

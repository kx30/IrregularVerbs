package com.example.irregularverbs.mvp.verb_list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.adapter.VerbAdapter
import com.example.irregularverbs.mvp.base.BaseActivity
import kotlinx.android.synthetic.main.activity_verbs_list.*

class VerbListActivity : BaseActivity(), VerbListView {

    @InjectPresenter
    lateinit var verbListPresenter: VerbListPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verbs_list)
        initActionBar()
        setChosenLevelInPresenter()
        verbListPresenter.initPresenter()
        initRecyclerView()
    }

    override fun setChosenLevelInPresenter() {
        val level = intent.getIntExtra(getString(R.string.TAG_LEVEL), 0)
        verbListPresenter.setLevel(level)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                verbListPresenter.initSearchLogic(newText)
                return true
            }
        })
        return true
    }

    override fun notifyDataSetChangedAdapter() {
        verbListRecyclerView.adapter = VerbAdapter(verbListPresenter.getSearchResultVerbs())
    }

    private fun initRecyclerView() {
        verbListRecyclerView.layoutManager = LinearLayoutManager(this)
        notifyDataSetChangedAdapter()
    }
}

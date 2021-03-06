package com.example.irregularverbs.mvp.verb_list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.adapter.VerbAdapter
import com.example.irregularverbs.mvp.base.BaseActivity
import com.example.irregularverbs.mvp.models.Verb
import com.example.irregularverbs.mvp.utils.CustomOnQueryTextListener
import kotlinx.android.synthetic.main.activity_verbs_list.*

class VerbListActivity : BaseActivity(), VerbListView, IrregularThings {

    @InjectPresenter
    lateinit var verbListPresenter: VerbListPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verbs_list)
        initActionBar()
        val startLevel = getChosenLevelForVerbs()
        verbListPresenter.initPresenter(startLevel) //TODO add parametr - fixed
        initRecyclerView()
    }

    //    verbListRecyclerView.adapter = VerbAdapter(verbListPresenter.getSearchResultVerbs())

    override fun getChosenLevelForVerbs(): Int {
        //        verbListPresenter.setLevel(level)
        return intent.getIntExtra(getString(R.string.TAG_LEVEL), 0)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : CustomOnQueryTextListener() {
            override fun onQueryTextChange(newText: String?): Boolean {
                verbListPresenter.initSearchLogic(newText)
                return true
            }
        })
        return true
    }

    //TODO MAKE NOTIFYDATASETCHANGED
    override fun notifyDataSetChangedAdapter() {
        verbListPresenter.initAdapter()
    }

    override fun initAdapter(searchResultVerbs: ArrayList<Verb>) {
        verbListRecyclerView.adapter = VerbAdapter(searchResultVerbs)
    }

    private fun initRecyclerView() {
        verbListRecyclerView.layoutManager = LinearLayoutManager(this)
        notifyDataSetChangedAdapter()
    }
}

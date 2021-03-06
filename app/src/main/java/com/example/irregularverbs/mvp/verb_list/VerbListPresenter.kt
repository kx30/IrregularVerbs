package com.example.irregularverbs.mvp.verb_list

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.irregularverbs.gateway.realm.RealmVerbGateway
import com.example.irregularverbs.mvp.models.Verb

@InjectViewState
class VerbListPresenter : MvpPresenter<VerbListView>() {

    private val searchResultVerbs = ArrayList<Verb>()
    private var verbList = ArrayList<Verb>()


    fun initPresenter(level: Int) {
        loadVerbList(level)
        fillSearchResultVerbs()
    }

    private fun loadVerbList(level: Int) {
        when (level) {
            0 -> verbList = RealmVerbGateway().loadVerbs(null)
            1 -> verbList = RealmVerbGateway().loadTooBadVerbs()
            2 -> verbList = RealmVerbGateway().loadSoSoBVerbs()
            3 -> verbList = RealmVerbGateway().loadExactlyKnownVerbs()
        }
    }

    fun initSearchLogic(newText: String?) {
        clearSearchResultVerbsList()
        if (!newText.isNullOrBlank()) {
            val search = newText.toLowerCase()
            updateSearchResultVerbsByTypedText(search)
        } else {
            fillSearchResultVerbs()
        }
        viewState.notifyDataSetChangedAdapter()
    }

    private fun clearSearchResultVerbsList() {
        searchResultVerbs.clear()
    }

    private fun updateSearchResultVerbsByTypedText(search: String) {
        verbList.forEach {
            if (it.firstForm.toLowerCase().contains(search) ||
                it.secondForm.toLowerCase().contains(search) ||
                it.thirdForm.toLowerCase().contains(search)
            ) {
                searchResultVerbs.add(it)
            }
        }
    }

    private fun fillSearchResultVerbs() {
        searchResultVerbs.addAll(verbList)
    }

    fun initAdapter() {
        viewState.initAdapter(searchResultVerbs) //TODO - FIXED
    }
}
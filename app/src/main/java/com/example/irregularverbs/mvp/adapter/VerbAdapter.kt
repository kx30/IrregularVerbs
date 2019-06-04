package com.example.irregularverbs.mvp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.models.Verb
import kotlinx.android.synthetic.main.verb_item.view.*

class VerbAdapter(private val verbList: List<Verb>) : RecyclerView.Adapter<VerbAdapter.VerbViewHolder>() {

    override fun onCreateViewHolder(view: ViewGroup, position: Int): VerbViewHolder {
        return VerbViewHolder(
            LayoutInflater.from(view.context).inflate(
                R.layout.verb_item,
                view,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VerbViewHolder, position: Int) {
        holder.onBind(position, verbList[position])
    }

    override fun getItemCount(): Int {
        return verbList.size
    }

    inner class VerbViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var currentVerb: Verb //TODO ASK SLAVIK

        fun onBind(position: Int, currentVerb: Verb) {
            this.currentVerb = currentVerb

            with(itemView) {
                firstFormOfVerbItemTextView.text = currentVerb.firstForm
                secondFormOfVerbItemTextView.text = currentVerb.secondForm
                thirdFormOfVerbItemTextView.text = currentVerb.thirdForm

                if (position % 2 == 1) {
                    setBackgroundResource(R.color.colorPrimary)
                } else {
                    setBackgroundResource(R.color.colorPrimaryDark)
                }
            }
        }
    }
}
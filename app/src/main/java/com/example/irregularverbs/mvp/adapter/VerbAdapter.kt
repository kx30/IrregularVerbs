package com.example.irregularverbs.mvp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.models.Verb
import kotlinx.android.synthetic.main.verb_item.view.*

class VerbAdapter(private val verbList: List<Verb>) : RecyclerView.Adapter<VerbViewHolder>() {
    override fun onCreateViewHolder(view: ViewGroup, position: Int): VerbViewHolder {
        val itemView = LayoutInflater.from(view.context).inflate(R.layout.verb_item, view, false)
        return VerbViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VerbViewHolder, position: Int) {
        val currentVerb = verbList[position]
        holder.firstForm.text = currentVerb.firstForm
        holder.secondForm.text = currentVerb.secondForm
        holder.thirdForm.text = currentVerb.thirdForm

        if (position % 2 == 1) {
            holder.itemView.setBackgroundResource(R.color.colorPrimary)
        } else {
            holder.itemView.setBackgroundResource(R.color.colorPrimaryDark)
        }
    }

    override fun getItemCount(): Int {
        return verbList.size
    }
}

class VerbViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    val firstForm = itemView.firstFormOfVerbItemTextView
    val secondForm = itemView.secondFormOfVerbItemTextView
    val thirdForm = itemView.thirdFormOfVerbItemTextView
}
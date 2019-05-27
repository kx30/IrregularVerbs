package com.example.irregularverbs.mvp.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.verb_item.view.*

class VerbViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    val firstForm = itemView.firstFormOfVerbItemTextView
    val secondForm = itemView.secondFormOfVerbItemTextView
    val thirdForm = itemView.thirdFormOfVerbItemTextView
}
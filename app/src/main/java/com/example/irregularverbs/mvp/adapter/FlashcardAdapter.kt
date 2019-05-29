package com.example.irregularverbs.mvp.adapter

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.irregularverbs.R
import com.example.irregularverbs.mvp.models.Verb
import com.wajahatkarim3.easyflipview.EasyFlipView
import kotlinx.android.synthetic.main.flashcard_back_item.view.*
import kotlinx.android.synthetic.main.flashcard_front_item.view.*

class FlashcardAdapter(private val verbList: List<Verb>) : RecyclerView.Adapter<FlashcardViewHolder>() {
    override fun onCreateViewHolder(view: ViewGroup, position: Int): FlashcardViewHolder {
        val itemView = LayoutInflater.from(view.context).inflate(R.layout.flashcard_item, view, false)
        return FlashcardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FlashcardViewHolder, position: Int) {
        val currentVerb = verbList[position]
        holder.firstFormOfVerbOnFrontSide.text = currentVerb.firstForm
        holder.firstFormOfVerbOnBackSide.text = currentVerb.firstForm
        holder.secondFormOfVerbOnBackSide.text = currentVerb.secondForm
        holder.thirdFormOfVerbOnBackSide.text = currentVerb.thirdForm
    }

    override fun getItemCount(): Int {
        return verbList.size
    }
}

class FlashcardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val frontSide: ConstraintLayout = itemView.findViewById(R.id.frontSide)
    private val backSide: ConstraintLayout = itemView.findViewById(R.id.backSide)
    private val flipView: EasyFlipView = itemView.findViewById(R.id.flipView)
    val firstFormOfVerbOnFrontSide = itemView.firstFormOfVerbTextViewOnFrontSide
    val firstFormOfVerbOnBackSide = itemView.firstFormOfVerbTextView
    val secondFormOfVerbOnBackSide = itemView.secondFormOfVerbTextView
    val thirdFormOfVerbOnBackSide = itemView.thirdFormOfVerbTextView

    init {
        frontSide.setOnClickListener {
            flipView.flipDuration = 500
            flipView.flipTheView()
        }
        backSide.setOnClickListener {
            flipView.flipDuration = 500
            flipView.flipTheView()
        }
    }

//    val firstForm = itemView.firstFormOfVerbItemTextView
//    val secondForm = itemView.secondFormOfVerbItemTextView
//    val thirdForm = itemView.thirdFormOfVerbItemTextView
}
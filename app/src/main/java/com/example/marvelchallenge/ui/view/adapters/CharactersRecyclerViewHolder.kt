package com.example.marvelchallenge.ui.view.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelchallenge.R

class CharactersRecyclerViewHolder(var view: View): RecyclerView.ViewHolder(view) {
    var nameCharacter: TextView? = view.findViewById(R.id.name_character)
    var imageCharacter: ImageView? = view.findViewById(R.id.thumb_character)
}
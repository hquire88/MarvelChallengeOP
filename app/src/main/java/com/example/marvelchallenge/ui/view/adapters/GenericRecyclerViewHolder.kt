package com.example.marvelchallenge.ui.view.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelchallenge.R

class GenericRecyclerViewHolder(var view: View): RecyclerView.ViewHolder(view) {
    var itemName: TextView? = view.findViewById(R.id.item_name)
    var itemImage: ImageView? = view.findViewById(R.id.item_thumb)
}
package com.example.marvelchallenge.ui.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelchallenge.R
import com.example.marvelchallenge.data.model.SubItemsModel

class SubItemsRecyclerViewAdapter(private var subItemsList: ArrayList<SubItemsModel>?):
        RecyclerView.Adapter<SubItemRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubItemRecyclerViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_subitem, parent, false)
        return SubItemRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (this.subItemsList?.size!! > 0 ){
            subItemsList?.size!!
        }else{
            0
        }
    }

    override fun onBindViewHolder(holder: SubItemRecyclerViewHolder, position: Int) {
        holder.itemName?.text = subItemsList?.get(position)?.name
    }
}
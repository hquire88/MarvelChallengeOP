package com.example.marvelchallenge.ui.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelchallenge.R
import com.example.marvelchallenge.core.utils.OnItemClickListener
import com.example.marvelchallenge.data.model.CharacterModel
import com.example.marvelchallenge.data.model.ThumbnailModel
import com.squareup.picasso.Picasso

class CharactersRecyclerViewAdapter(private var charactersList: ArrayList<CharacterModel>?):
        RecyclerView.Adapter<GenericRecyclerViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericRecyclerViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return GenericRecyclerViewHolder(view, mListener)
    }

    override fun getItemCount(): Int {
        return if (this.charactersList?.size!! > 0 ){
            charactersList?.size!!
        }else{
            0
        }
    }

    override fun onBindViewHolder(holder: GenericRecyclerViewHolder, position: Int) {
        holder.itemName?.text = charactersList?.get(position)?.name
        Picasso.get().load(charactersList?.get(position)?.thumbnail?.getImgUrlBySize(ThumbnailModel.SIZE_LARGE))
            .into(holder.itemImage)
    }
}
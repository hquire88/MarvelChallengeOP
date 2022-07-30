package com.example.marvelchallenge.ui.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelchallenge.R
import com.example.marvelchallenge.data.model.CharacterModel
import com.squareup.picasso.Picasso

class CharacterRecyclerViewAdapter(context: Context, private var charactersList: ArrayList<CharacterModel>?):
        RecyclerView.Adapter<CharactersRecyclerViewHolder>() {

    val cont = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersRecyclerViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_characters, parent, false)
        return CharactersRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (this.charactersList?.size!! > 0 ){
            charactersList?.size!!
        }else{
            0
        }
    }

    override fun onBindViewHolder(holder: CharactersRecyclerViewHolder, position: Int) {
        holder.nameCharacter?.text = charactersList?.get(position)?.name
        val concatURL = charactersList?.get(position)?.thumbnail?.path + "." + charactersList?.get(position)?.thumbnail?.extension
        Picasso.get().load(concatURL).into(holder.imageCharacter)
    }

    fun setItems(newItems: ArrayList<CharacterModel>) {
        charactersList?.addAll(newItems)
        notifyDataSetChanged()
    }
}
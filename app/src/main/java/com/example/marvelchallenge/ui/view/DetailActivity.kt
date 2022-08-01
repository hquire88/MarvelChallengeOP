package com.example.marvelchallenge.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelchallenge.R
import com.example.marvelchallenge.data.model.CharacterModel
import com.example.marvelchallenge.data.model.ThumbnailModel
import com.example.marvelchallenge.databinding.ActivityDetailBinding
import com.example.marvelchallenge.ui.view.adapters.SubItemsRecyclerViewAdapter
import com.example.marvelchallenge.ui.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailBinding
    private var position: Int = 0

    private val detailViewModel: DetailViewModel by viewModels()
    private lateinit var comicRVAdapter: SubItemsRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        detailViewModel.onCreate()

        position = intent.getIntExtra("position",0)

        detailViewModel.resultSelCharModel.observe(this, Observer {
            setData(it[position])
        })
    }

    private fun setData(selChar: CharacterModel){
        detailBinding.nameCharacter.text = selChar.name
        detailBinding.descCharacter.text = selChar.description
        Picasso.get().load(selChar.thumbnail.getImgUrlBySize(ThumbnailModel.SIZE_FANTASTIC))
            .into(detailBinding.itemThumb)

        val lLayout = LinearLayoutManager(this@DetailActivity, LinearLayoutManager.VERTICAL, false)
        val comicsRView = findViewById<View>(R.id.subitem_comics) as RecyclerView
        comicsRView.setHasFixedSize(true)
        comicsRView.layoutManager = lLayout

        comicRVAdapter = SubItemsRecyclerViewAdapter(selChar.comics.items)
        comicsRView.adapter = comicRVAdapter
    }
}
package com.example.marvelchallenge.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelchallenge.R
import com.example.marvelchallenge.core.utils.OnItemClickListener
import com.example.marvelchallenge.data.model.CharacterModel
import com.example.marvelchallenge.data.model.ComicModel
import com.example.marvelchallenge.data.model.ThumbnailModel
import com.example.marvelchallenge.databinding.ActivityDetailBinding
import com.example.marvelchallenge.ui.view.adapters.ComicsRecyclerViewAdapter
import com.example.marvelchallenge.ui.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailBinding
    private var position: Int = 0
    private var idCharacter: Int = 0

    private val detailViewModel: DetailViewModel by viewModels()
    private lateinit var comicRVAdapter: ComicsRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        position = intent.getIntExtra("position",0)
        idCharacter = intent.getIntExtra("idCharacter",0)

        detailViewModel.onCreate(idCharacter)

        detailViewModel.resultSelectedCharModel.observe(this) {
            if (it != null) {
                setData(it)
            }
        }
        detailViewModel.resultComicsByCharacterModel.observe(this, Observer {
            setComicsData(it)
        })
    }

    private fun setData(selChar: CharacterModel){
        detailBinding.nameCharacter.text = selChar.name
        detailBinding.descCharacter.text = selChar.description
        Picasso.get().load(selChar.thumbnail.getImgUrlBySize(ThumbnailModel.SIZE_FANTASTIC))
            .into(detailBinding.itemThumb)
    }

    private fun setComicsData(comics: ArrayList<ComicModel>){
        val lLayout = LinearLayoutManager(this@DetailActivity, LinearLayoutManager.HORIZONTAL, false)
        val comicsRView = findViewById<View>(R.id.subitem_comics) as RecyclerView
        comicsRView.setHasFixedSize(true)
        comicsRView.layoutManager = lLayout

        comicRVAdapter = ComicsRecyclerViewAdapter(comics)
        comicsRView.adapter = comicRVAdapter
        comicRVAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(this@DetailActivity, "Posicion Comic: ${position+1}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
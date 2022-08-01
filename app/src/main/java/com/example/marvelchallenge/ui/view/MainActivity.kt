package com.example.marvelchallenge.ui.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.marvelchallenge.R
import com.example.marvelchallenge.databinding.ActivityMainBinding
import com.example.marvelchallenge.ui.view.adapters.CharactersRecyclerViewAdapter
import com.example.marvelchallenge.ui.view.adapters.ComicsRecyclerViewAdapter
import com.example.marvelchallenge.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var charRVAdapter: CharactersRecyclerViewAdapter
    private lateinit var comicRVAdapter: ComicsRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        mainViewModel.onCreate()

        val lLayout = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        val lLayout2 = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)

        val characterRView = findViewById<View>(R.id.charactersRecyclerView) as RecyclerView
        characterRView.setHasFixedSize(true)
        characterRView.layoutManager = lLayout

        val comicsRView = findViewById<View>(R.id.comicsRecyclerView) as RecyclerView
        comicsRView.setHasFixedSize(true)
        comicsRView.layoutManager = lLayout2

        // Stop item by item
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(characterRView)
        snapHelper.attachToRecyclerView(comicsRView)

        mainViewModel.resultCharacterModel.observe(this, Observer {
            // set recyclerView con los datos obtenidos
            charRVAdapter = CharactersRecyclerViewAdapter(it.data.results)
            characterRView.adapter = charRVAdapter
        })

        mainViewModel.resultComicModel.observe(this, Observer {
            // set recyclerView con los datos obtenidos
            comicRVAdapter = ComicsRecyclerViewAdapter(it.data.results)
            comicsRView.adapter = comicRVAdapter
        })

        mainViewModel.isLoading.observe(this, Observer {
            activityMainBinding.progressBar.isVisible = it
        })

        mainViewModel.getCharacters()
    }
}
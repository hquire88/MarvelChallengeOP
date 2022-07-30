package com.example.marvelchallenge.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.*
import com.example.marvelchallenge.R
import com.example.marvelchallenge.databinding.ActivityMainBinding
import com.example.marvelchallenge.ui.view.adapters.CharacterRecyclerViewAdapter
import com.example.marvelchallenge.ui.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    private val characterViewModel: CharacterViewModel by viewModels()
    private lateinit var rcAdapter: CharacterRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        characterViewModel.onCreate()

        val lLayout = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        val rView = findViewById<View>(R.id.charactersRecyclerView) as RecyclerView
        rView.setHasFixedSize(true)
        rView.layoutManager = lLayout
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rView)

        characterViewModel.resultModel.observe(this, Observer {
            // set recyclerView con los datos obtenidos
            rcAdapter = CharacterRecyclerViewAdapter(this, it.data.results)
            rView.adapter = rcAdapter
        })

        characterViewModel.isLoading.observe(this, Observer {
            activityMainBinding.progressBar.isVisible = it
        })

        characterViewModel.getCharacters()
    }
}
package com.example.arispanayiotou.kotlin

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.arispanayiotou.kotlin.adapter.MovieAdapter
import kotlinx.android.synthetic.main.activity_main.*
import com.example.arispanayiotou.kotlin.models.MovieModel
import com.example.arispanayiotou.kotlin.viewModels.MoviesViewModel


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        model.getMovies().observe(this, Observer<MutableList<MovieModel>> {
            recyclerview.adapter = MovieAdapter(it!!)
        })

    }

}




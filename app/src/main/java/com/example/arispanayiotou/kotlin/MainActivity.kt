package com.example.arispanayiotou.kotlin

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.arispanayiotou.kotlin.adapter.MovieAdapter
import kotlinx.android.synthetic.main.activity_main.*
import com.example.arispanayiotou.kotlin.models.MovieModel
import com.example.arispanayiotou.kotlin.viewModels.MoviesViewModel
import android.widget.Toast
import com.example.arispanayiotou.kotlin.models.MoviesResponseObject
import com.example.arispanayiotou.kotlin.viewModels.MainActivityViewModel


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val model = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
//        model.getMovies().observe(this, Observer<MutableList<MovieModel>> {
//            recyclerview.adapter = MovieAdapter(it!!)
//        })


        val viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        viewModel.getMovies().observe(this, Observer<MoviesResponseObject> { apiResponse ->
            if (apiResponse == null) {
                // handle error here
                return@Observer
            }
            if (apiResponse.error == null) {
                // call is successful
                if (apiResponse.networkCodeErrorModel == null)
                    recyclerview.adapter = MovieAdapter(apiResponse.results!!)
                else
                    Toast.makeText(this@MainActivity, "Error Message " + apiResponse.networkCodeErrorModel?.errorMessage
                        + " Error code " + apiResponse.networkCodeErrorModel?.networkErrorCode, Toast.LENGTH_SHORT).show()
            } else {
                // call failed.
                val e = apiResponse.error
                Toast.makeText(this@MainActivity, "Error is " + e?.message, Toast.LENGTH_SHORT).show()
                Log.e("TEST", "Error is " + e?.getLocalizedMessage())

            }
        })


    }

}




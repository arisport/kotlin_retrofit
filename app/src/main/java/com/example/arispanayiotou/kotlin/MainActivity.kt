package com.example.arispanayiotou.kotlin

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.arispanayiotou.kotlin.adapter.MovieAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import com.example.arispanayiotou.kotlin.models.MoviesResponseObject
import com.example.arispanayiotou.kotlin.models.network.AbstractResponseObject
import com.example.arispanayiotou.kotlin.models.network.ServerErrorModel
import com.example.arispanayiotou.kotlin.viewModels.MainActivityViewModel


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        viewModel.getMovies().observe(this, Observer<MoviesResponseObject> {

            if (it == null) {
                // handle error here
                return@Observer
            }

            when (it.errorType) {
                AbstractResponseObject.ErrorType.NONE -> recyclerview.adapter = MovieAdapter(it.results!!)
                AbstractResponseObject.ErrorType.SERVER_ERROR -> showServerErrorMessage(it.serverErrorModel)
                AbstractResponseObject.ErrorType.NETWORK_ERROR -> showNetworkErrorMessage(it.networkError)
            }


        })


    }

    private fun showNetworkErrorMessage(networkError: Throwable?) {
        Toast.makeText(this@MainActivity, "Error is " + networkError?.message, Toast.LENGTH_SHORT).show()
        Log.e("TEST", "Error is " + networkError?.localizedMessage)
    }

    private fun showServerErrorMessage(serverErrorModel: ServerErrorModel?) {
        Toast.makeText(
            this@MainActivity,
            "Error Message " + serverErrorModel?.errorMessage
                    + " Error code " + serverErrorModel?.networkErrorCode,
            Toast.LENGTH_SHORT
        ).show()
    }

}




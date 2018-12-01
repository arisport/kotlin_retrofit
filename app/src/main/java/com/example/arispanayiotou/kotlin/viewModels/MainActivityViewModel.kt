package com.example.arispanayiotou.kotlin.viewModels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.arispanayiotou.kotlin.models.MoviesResponseObject
import com.example.arispanayiotou.kotlin.repositories.MovieRepository


/**
 * Created by arispanayiotou on 01/12/2018
 */
class MainActivityViewModel : ViewModel() {


    private var apiResponse: MediatorLiveData<MoviesResponseObject> = MediatorLiveData()
    private var movieRepo: MovieRepository = MovieRepository()

    fun getMovies(): LiveData<MoviesResponseObject> {

        apiResponse.addSource(movieRepo.getMovies()) {
            apiResponse.value = it
        }

        return apiResponse
    }

}
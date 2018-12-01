package com.example.arispanayiotou.kotlin.viewModels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.arispanayiotou.kotlin.endpoints.MoviesEndPoint
import com.example.arispanayiotou.kotlin.models.MovieModel
import com.example.arispanayiotou.kotlin.models.MoviesResponseObject
import com.example.arispanayiotou.kotlin.utilities.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by arispanayiotou on 01/12/2018
 */
class MoviesViewModel : ViewModel(), Callback<MoviesResponseObject> {

    private lateinit var movieModel: MutableLiveData<MutableList<MovieModel>>
    private lateinit var errorMessage: String

    fun getMovies(): LiveData<MutableList<MovieModel>> {
        if (!::movieModel.isInitialized) {
            movieModel = MutableLiveData()
            loadUsers()
        }
        return movieModel
    }

    private fun loadUsers() {

        val service = RetrofitClientInstance.getRetrofitInstance().create(MoviesEndPoint::class.java)
        val call = service.getMovie()
        call.enqueue(this)
    }

    override fun onFailure(call: Call<MoviesResponseObject>, t: Throwable) {
        println("Error," + t.toString())
    }

    override fun onResponse(call: Call<MoviesResponseObject>, response: Response<MoviesResponseObject>) {

        if (response.isSuccessful) {
            movieModel.value = response.body()?.results
        } else {
            errorMessage = response.message()
        }
    }

}
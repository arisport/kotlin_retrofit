package com.example.arispanayiotou.kotlin.repositories

import com.example.arispanayiotou.kotlin.endpoints.MoviesEndPoint
import com.example.arispanayiotou.kotlin.models.MoviesResponseObject
import com.example.arispanayiotou.kotlin.utilities.RetrofitClientInstance
import retrofit2.Call
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.LiveData
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by arispanayiotou on 01/12/2018
 */
class MovieRepository : Callback<MoviesResponseObject> {


    val service = RetrofitClientInstance.getRetrofitInstance().create(MoviesEndPoint::class.java)
    var apiResponse = MutableLiveData<MoviesResponseObject>()


    fun getMovies() {
        val apiResponseObject = MutableLiveData<MoviesResponseObject>()
        val call = service.getMovie()
        call.enqueue(this)
    }

    override fun onFailure(call: Call<MoviesResponseObject>, t: Throwable) {
        val moviesResponseObject = MoviesResponseObject()
        moviesResponseObject.error = t
        apiResponse.postValue(moviesResponseObject)
    }

    override fun onResponse(call: Call<MoviesResponseObject>, response: Response<MoviesResponseObject>) {
        if (response.isSuccessful) {
            apiResponse.postValue(response.body())
        }
    }

}
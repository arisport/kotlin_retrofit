package com.example.arispanayiotou.kotlin.repositories

import com.example.arispanayiotou.kotlin.endpoints.MoviesEndPoint
import com.example.arispanayiotou.kotlin.models.MoviesResponseObject
import com.example.arispanayiotou.kotlin.utilities.RetrofitClientInstance
import retrofit2.Call
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.arispanayiotou.kotlin.models.NetworkCodeErrorModel
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by arispanayiotou on 01/12/2018
 */
class MovieRepository {

    private val service = RetrofitClientInstance.getRetrofitInstance().create(MoviesEndPoint::class.java)


    fun getMovies(): MutableLiveData<MoviesResponseObject> {
        val apiResponseObject = MutableLiveData<MoviesResponseObject>()
        val call = service.getMovie()

        call.enqueue(object : Callback<MoviesResponseObject> {
            override fun onFailure(call: Call<MoviesResponseObject>, t: Throwable?) {
                val moviesResponseObject = MoviesResponseObject()
                moviesResponseObject.error = t
                apiResponseObject.postValue(moviesResponseObject)
            }

            override fun onResponse(call: Call<MoviesResponseObject>, response: Response<MoviesResponseObject>) {
                if (response.isSuccessful) {
                    apiResponseObject.postValue(response.body())
                } else {
                    val moviesResponseObject = MoviesResponseObject()
                    val networkCodeErrorModel = NetworkCodeErrorModel(response.code(),response.message())
                    moviesResponseObject.networkCodeErrorModel = networkCodeErrorModel
                    apiResponseObject.postValue(moviesResponseObject)
                }
            }
        })

        return apiResponseObject
    }

}
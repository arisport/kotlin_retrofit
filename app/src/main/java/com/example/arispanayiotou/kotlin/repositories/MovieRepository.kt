package com.example.arispanayiotou.kotlin.repositories

import com.example.arispanayiotou.kotlin.endpoints.MoviesEndPoint
import com.example.arispanayiotou.kotlin.models.MoviesResponseObject
import com.example.arispanayiotou.kotlin.utilities.RetrofitClientInstance
import android.arch.lifecycle.MutableLiveData
import com.example.arispanayiotou.kotlin.models.network.AbstractResponseObject
import com.example.arispanayiotou.kotlin.models.network.ServerErrorModel
import com.example.arispanayiotou.kotlin.utilities.extensions.enqueueExtension


/**
 * Created by arispanayiotou on 01/12/2018
 */
class MovieRepository {

    private val service = RetrofitClientInstance.getRetrofitInstance().create(MoviesEndPoint::class.java)


    fun getMovies(): MutableLiveData<MoviesResponseObject> {
        val apiResponseObject = MutableLiveData<MoviesResponseObject>()
        val call = service.getMovie()

        call.enqueueExtension {

            onResponse = {
                if (it.isSuccessful) {
                    apiResponseObject.postValue(it.body())
                } else {
                    val moviesResponseObject = MoviesResponseObject()
                    moviesResponseObject.errorType = AbstractResponseObject.ErrorType.SERVER_ERROR
                    moviesResponseObject.serverErrorModel = ServerErrorModel(it.code(), it.message())
                    apiResponseObject.postValue(moviesResponseObject)
                }
            }

            onFailure = {
                val moviesResponseObject = MoviesResponseObject()
                moviesResponseObject.networkError = it
                moviesResponseObject.errorType = AbstractResponseObject.ErrorType.NETWORK_ERROR
                apiResponseObject.postValue(moviesResponseObject)
            }

        }


        return apiResponseObject
    }

}
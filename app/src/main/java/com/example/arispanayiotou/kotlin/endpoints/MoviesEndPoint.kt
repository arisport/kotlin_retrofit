package com.example.arispanayiotou.kotlin.endpoints

import com.example.arispanayiotou.kotlin.models.MovieModel
import com.example.arispanayiotou.kotlin.models.MoviesResponseObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by arispanayiotou on 29/11/2018
 */
interface MoviesEndPoint {

    @GET("search.json/")
    fun getMovie(): Call<MoviesResponseObject>

}
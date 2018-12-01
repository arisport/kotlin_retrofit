package com.example.arispanayiotou.kotlin.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by arispanayiotou on 01/12/2018
 */
class MoviesResponseObject() {

    @Expose
    val status: String? = null
    @SerializedName("copyright")
    @Expose
    val copyright: String? = null
    @SerializedName("has_more")
    @Expose
    val hasMore: Boolean? = null
    @SerializedName("num_results")
    @Expose
    val numResults: Int? = null
    @SerializedName("results")
    @Expose
    val results: MutableList<MovieModel>? = null

    var error: Throwable? = null

}
package com.example.arispanayiotou.kotlin.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by arispanayiotou on 01/12/2018
 */
class MultimediaModel {

    @SerializedName("type")
    @Expose
    val type: String? = null
    @SerializedName("src")
    @Expose
    val src: String? = null
    @SerializedName("width")
    @Expose
    val width: Int? = null
    @SerializedName("height")
    @Expose
    val height: Int? = null


}
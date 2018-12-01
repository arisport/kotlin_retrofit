package com.example.arispanayiotou.kotlin.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by arispanayiotou on 01/12/2018
 */
class LinkModel {

    @SerializedName("type")
    @Expose
    val type: String? = null
    @SerializedName("url")
    @Expose
    val url: String? = null
    @SerializedName("suggested_link_text")
    @Expose
    val suggestedLinkText: String? = null

}
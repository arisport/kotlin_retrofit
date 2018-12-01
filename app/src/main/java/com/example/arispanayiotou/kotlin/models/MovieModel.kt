package com.example.arispanayiotou.kotlin.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by arispanayiotou on 29/11/2018
 */
class MovieModel {

    @SerializedName("display_title")
    @Expose
    val displayTitle: String? = null
    @SerializedName("mpaa_rating")
    @Expose
    val mpaaRating: String? = null
    @SerializedName("critics_pick")
    @Expose
    val criticsPick: Int? = null
    @SerializedName("byline")
    @Expose
    val byline: String? = null
    @SerializedName("headline")
    @Expose
    val headline: String? = null
    @SerializedName("summary_short")
    @Expose
    val summaryShort: String? = null
    @SerializedName("publication_date")
    @Expose
    val publicationDate: String? = null
    @SerializedName("opening_date")
    @Expose
    val openingDate: String? = null
    @SerializedName("date_updated")
    @Expose
    val dateUpdated: String? = null
    @SerializedName("link")
    @Expose
    val link: LinkModel? = null
    @SerializedName("multimedia")
    @Expose
    val multimedia: MultimediaModel? = null


}
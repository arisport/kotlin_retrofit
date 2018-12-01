package com.example.arispanayiotou.kotlin.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by arispanayiotou on 29/11/2018
 */
class RatingObject (@SerializedName("Source") @Expose var source: String,
                    @SerializedName("Value") @Expose var value : String){
}
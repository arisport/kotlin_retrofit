package com.example.arispanayiotou.kotlin.utilities

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by arispanayiotou on 30/11/2018
 */

fun ImageView.loadImageViewWithGlide(url: String) {

    Glide.with(context)
        .load(url)
        .into(this)

}
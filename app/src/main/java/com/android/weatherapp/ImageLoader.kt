package com.android.weatherapp

import android.widget.ImageView

interface ImageLoader {
    fun loadImageFromUrl(view: ImageView, url: String, callback: (() -> Unit)? = null)
}
package com.android.weatherapp

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GlideImageLoader @Inject constructor(@ApplicationContext context: Context) : ImageLoader {
    private val requestManager: RequestManager = Glide.with(context)

    override fun loadImageFromUrl(view: ImageView, url: String, callback: (() -> Unit)?) {
        loadAny(view, url, callback)
    }

    private fun loadAny(view: ImageView, any: Any?, callback: (() -> Unit)?) {
        requestManager.load(any)
            .addListener(object : RequestListener<Drawable?> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable?>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable?>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    callback?.invoke()
                    return false
                }
            }).into(view)
    }
}

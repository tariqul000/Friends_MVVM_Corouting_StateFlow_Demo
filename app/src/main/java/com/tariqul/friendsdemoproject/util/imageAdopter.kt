package com.tariqul.friendsdemoproject.util

import android.R
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("imageUrl")

fun loadImage(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        val circularProgressDrawable = CircularProgressDrawable(view.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        val requestOptions = RequestOptions().apply {
            placeholder(circularProgressDrawable)
            skipMemoryCache(true)
            fitCenter()
        }
        // Glide.with(view.context).load(url).into(view)
        Glide.with(view.context) //passing your url to load image.
            .load(url)
            .apply(requestOptions) // here you have all options you need
            .transition(DrawableTransitionOptions.withCrossFade()) // when image (url) will be loaded by glide then this face in animation help to replace url image in the place of placeHolder (default) image.
            .into(view);
    }
}
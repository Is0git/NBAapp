package com.android.nbaapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageBindingAdapter {

    @BindingAdapter("loadImage")
    @JvmStatic
    fun loadImage(view:ImageView, image_url:String?) {
        if(image_url != null) Glide.with(view.context).load(image_url).centerCrop().into(view)
    }
}
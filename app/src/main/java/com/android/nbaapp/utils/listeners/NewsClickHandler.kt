package com.android.nbaapp.utils.listeners

import android.view.View

interface NewsClickHandler<T> {
    fun onNewsClick(view1: View, view2: View, data:T)
}
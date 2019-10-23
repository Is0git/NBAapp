package com.android.nbaapp.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.android.nbaapp.R;
import com.bumptech.glide.Glide;

public class TeamImageChange {
    @BindingAdapter("syncImage")
    public static void syncImage(ImageView view, String teamName) {
        teamName = teamName.replace(" ", "_");
        int id = view.getContext().getResources().getIdentifier(teamName.toLowerCase(), "drawable", view.getContext().getPackageName());
        Glide.with(view).load(id).into(view);
    }
}

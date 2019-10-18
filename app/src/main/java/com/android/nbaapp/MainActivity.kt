package com.android.nbaapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.nbaapp.data.services.GamesService
import dagger.android.support.DaggerAppCompatActivity
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
        @Inject lateinit var retrofit: Retrofit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bind = retrofit.create(GamesService::class.java)
        Log.d("TAG", "SERBICE: $bind")
    }
}

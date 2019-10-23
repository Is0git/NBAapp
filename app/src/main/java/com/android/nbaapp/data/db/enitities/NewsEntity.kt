package com.android.nbaapp.data.db.enitities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "news_table")
data class NewsEntity( val title:String = "N/A", val image_url:String?, val description:String?, val secondaryText:String?, val user_image:String?, val isFavorite:Boolean = false, @PrimaryKey(autoGenerate = true) val id:Int=0)
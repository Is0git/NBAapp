package com.android.nbaapp.data.db.enitities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "news_table")
data class NewsEntity(@PrimaryKey(autoGenerate = true) val id:Int, val title:String = "N/A", val image_url:String?)
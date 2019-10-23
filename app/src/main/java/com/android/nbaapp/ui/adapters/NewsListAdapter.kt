package com.android.nbaapp.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.nbaapp.data.db.enitities.NewsEntity
import com.android.nbaapp.databinding.NewsListViewBinding
import com.android.nbaapp.di.mainActivity.ActivityContextQualifier
import com.android.nbaapp.di.mainActivity.homeFragment.newsFragment.NewsFragmentScope
import javax.inject.Inject

@NewsFragmentScope
class NewsListAdapter @Inject constructor(@ActivityContextQualifier val context: Context) :
    ListAdapter<NewsEntity, NewsListAdapter.MyViewHolder>(newsCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.d("BOD", "POSITION: RR")
        val binding = NewsListViewBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    init {
        Log.d("BOD", "POSITION: SS")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.root.setOnClickListener { Log.d("TAG1", "CLICKLED") }
        Log.d("BOD", "POSITION: $position")
        val item = getItem(position)
        holder.binding.data = item
    }


    class MyViewHolder(val binding: NewsListViewBinding) : RecyclerView.ViewHolder(binding.root)
}

val newsCallback = object : DiffUtil.ItemCallback<NewsEntity>() {
    override fun areItemsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean =
        oldItem == newItem
}

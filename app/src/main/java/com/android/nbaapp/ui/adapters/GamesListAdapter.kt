package com.android.nbaapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.nbaapp.data.models.GamesPojo
import com.android.nbaapp.databinding.AllGamesListBinding

class GamesListAdapter : PagedListAdapter<GamesPojo.Data, GamesListAdapter.MyViewHolder>(callback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = AllGamesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.item = item
    }

    class MyViewHolder(val binding: AllGamesListBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}

val callback = object : DiffUtil.ItemCallback<GamesPojo.Data>() {
    override fun areItemsTheSame(oldItem: GamesPojo.Data, newItem: GamesPojo.Data): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: GamesPojo.Data, newItem: GamesPojo.Data): Boolean = oldItem == newItem
}
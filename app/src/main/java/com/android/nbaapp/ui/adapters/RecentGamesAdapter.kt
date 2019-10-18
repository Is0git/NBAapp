package com.android.nbaapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.android.nbaapp.data.models.GamesPojo
import com.android.nbaapp.databinding.RecentGamesViewPagerBinding
import javax.inject.Inject

class RecentGamesAdapter @Inject constructor(val context: Context) : PagerAdapter() {
    var games: GamesPojo.SeasonGames? = null

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val recentGamesViewPagerBinding = RecentGamesViewPagerBinding.inflate(LayoutInflater.from(context), container, false)
        val item = games?.data?.get(position)
        recentGamesViewPagerBinding.games = item
        return recentGamesViewPagerBinding.root

    }

    override fun getCount(): Int {
        return games?.data?.size ?: 0
    }

    fun setData(games: GamesPojo.SeasonGames) {
        this.games = games
        notifyDataSetChanged()
    }
}
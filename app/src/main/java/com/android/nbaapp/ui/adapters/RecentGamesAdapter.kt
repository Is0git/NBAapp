package com.android.nbaapp.ui.adapters

import android.content.Context
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.android.nbaapp.data.models.GamesPojo
import com.android.nbaapp.databinding.RecentGamesViewPagerBinding
import com.android.nbaapp.di.mainActivity.ActivityContextQualifier
import okhttp3.internal.notifyAll
import javax.inject.Inject

class RecentGamesAdapter @Inject constructor(@ActivityContextQualifier val context: Context) : PagerAdapter() {
    var games: GamesPojo.SeasonGames? = null
    lateinit var recentGamesViewPagerBinding:RecentGamesViewPagerBinding

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        Log.d("TAG", "ROTTEN")
         recentGamesViewPagerBinding = RecentGamesViewPagerBinding.inflate(LayoutInflater.from(context), container, false)
        val item = games?.data?.get(position)
        recentGamesViewPagerBinding.games = item
        container.addView(recentGamesViewPagerBinding.root)
        return recentGamesViewPagerBinding.root

    }

    override fun getCount(): Int {
        Log.d("TAG", "size: ${games?.data?.size}")
        if(games != null) {
            return games!!.data!!.size
        }
            return 0
    }

    fun setData(new_games: GamesPojo.SeasonGames) {
        this.games = new_games
        notifyDataSetChanged()
    }

    override fun restoreState(state: Parcelable?, loader: ClassLoader?) {
        super.restoreState(state, loader)
    }

    override fun notifyDataSetChanged() {
        super.notifyDataSetChanged()
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
package com.android.nbaapp.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.android.nbaapp.ui.fragments.GamesFragment
import com.android.nbaapp.ui.fragments.NewsFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, behaviour:Int) : FragmentPagerAdapter(fragmentManager, behaviour) {
    override fun getItem(position: Int): Fragment = if (position == 0) NewsFragment() else GamesFragment()

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? = if(position == 0) "News" else "Games"
}
package com.jydev.d_time_renewal.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MainPagerAdapter(fm : FragmentManager, private val fragmentList:MutableList<Fragment>) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment = fragmentList[position]
    override fun getCount(): Int = fragmentList.size
}
package com.jydev.d_time_renewal.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.jydev.d_time_renewal.R
import com.jydev.d_time_renewal.base.BaseActivity
import com.jydev.d_time_renewal.databinding.ActivityMainBinding
import com.jydev.d_time_renewal.ui.main.diary.DiaryFragment
import com.jydev.d_time_renewal.ui.main.timetable.TimeTableFragment
import com.jydev.d_time_renewal.ui.main.todo.TodoFragment
import org.koin.core.KoinComponent

class MainActivity : BaseActivity(),KoinComponent {
    val binding by binding<ActivityMainBinding>(R.layout.activity_main)
    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@MainActivity
            pagerAdapter = MainPagerAdapter(
                supportFragmentManager,
                getFragmentList()
            )
            mainViewModel = viewModel
        }
    }

    private fun getFragmentList(): MutableList<Fragment> =
        mutableListOf(TimeTableFragment(), TodoFragment(), DiaryFragment())
}
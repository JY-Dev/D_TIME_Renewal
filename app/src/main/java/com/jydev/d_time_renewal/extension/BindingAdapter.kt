package com.jydev.d_time_renewal.extension

import android.widget.CheckBox
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.jydev.d_time_renewal.model.TodoData
import com.jydev.d_time_renewal.ui.main.MainPagerAdapter
import com.jydev.d_time_renewal.ui.main.MainPage


/**
 * Main
 */
@BindingAdapter("bind:pagerAdapter")
fun setPagerAdapter(view : ViewPager , adapter : MainPagerAdapter){
    view.apply {
        this.adapter = adapter
        currentItem = MainPage.TODO.index
    }
}

@BindingAdapter("bind:addPagerListener")
fun addOnPageChangeListener(view : ViewPager , title : MutableLiveData<String>){
    val titleList = mutableListOf("TIMETABLE","D TIME","DIARY")
    view.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
        override fun onPageScrollStateChanged(state: Int) {}
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
        override fun onPageSelected(position: Int) {
            title.postValue(titleList[position])
        }
    })
}

/**
 * TODO
 */
@BindingAdapter("bind:recyclerViewAdapter")
fun setAdapter(view: RecyclerView, baseAdapter: RecyclerView.Adapter<*>) {
    view.adapter = baseAdapter
}

@BindingAdapter("bind:checkedUpdate")
fun setOnCheckedChangeListener(view : CheckBox , isCleared : MutableLiveData<Boolean>){
    view.setOnCheckedChangeListener { _, isChecked ->
        isCleared.postValue(isChecked)
    }
}

@BindingAdapter("bind:setPaintFlag")
fun setPaintFlag(view : TextView , isCleared: MutableLiveData<Boolean>){
    view.paintFlags
}
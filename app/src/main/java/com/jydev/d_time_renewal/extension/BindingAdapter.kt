package com.jydev.d_time_renewal.extension

import android.graphics.Paint
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.jydev.d_time_renewal.model.todo.TodoData
import com.jydev.d_time_renewal.model.todo.TodoDataStatus
import com.jydev.d_time_renewal.model.todo.TodoStatus
import com.jydev.d_time_renewal.ui.dialog.CalendarDialog
import com.jydev.d_time_renewal.ui.main.MainPage
import com.jydev.d_time_renewal.ui.main.MainPagerAdapter
import com.jydev.d_time_renewal.ui.main.todo.adapter.TodoAdapter


/**
 * Main
 */
@BindingAdapter("bind:pagerAdapter")
fun setPagerAdapter(view: ViewPager, adapter: MainPagerAdapter) {
    view.apply {
        this.adapter = adapter
        currentItem = MainPage.TODO.index
    }
}

@BindingAdapter("bind:addPagerListener")
fun addOnPageChangeListener(view: ViewPager, title: MutableLiveData<String>) {
    val titleList = mutableListOf("TIMETABLE", "D TIME", "DIARY")
    view.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {}
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            title.postValue(titleList[position])
        }
    })
}

/**
 * TODO
 */
@BindingAdapter(value = ["todo:recyclerViewAdapter" ,"todo:setItemDecoration","todo:todoLiveData"] , requireAll = false)
fun setAdapter(view: RecyclerView, adapter: TodoAdapter , itemDecoration: RecyclerView.ItemDecoration?,todoLiveData: MutableLiveData<TodoDataStatus>?) {
    view.adapter = adapter.apply {
        registerAdapterDataObserver(object: RecyclerView.AdapterDataObserver() {
            override fun onChanged() {
                view.smoothScrollToPosition(adapter.itemCount)
            }
        })
    }
    itemDecoration?.run {
        view.addItemDecoration(this)
    }
    todoLiveData?.run {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = true

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                todoLiveData.postValue(
                    TodoDataStatus(
                        adapter.todoList[viewHolder.adapterPosition],
                        TodoStatus.Delete
                    )
                )
            }
        }).attachToRecyclerView(view)
    }
}

@BindingAdapter("todo:setPaintFlag")
fun setPaintFlag(view: TextView, isCleared: Boolean) {
    view.paintFlags = if (isCleared) Paint.STRIKE_THRU_TEXT_FLAG else Paint.HINTING_OFF
}

@BindingAdapter("todo:checkedUpdate", "todo:todoData")
fun setOnCheckedChangeListener(
    view: CheckBox,
    todoLiveData: MutableLiveData<TodoDataStatus>,
    todoData: TodoData
) {
    view.setOnCheckedChangeListener { _, isChecked ->
        todoLiveData.postValue(
            TodoDataStatus(todoData.apply {
                isClear = isChecked
            }, TodoStatus.Update)
        )
    }
}

@BindingAdapter("todo:onClickAdd", "todo:todoLiveData")
fun setOnclick(view:ImageButton , todoData: TodoData , todoLiveData: MutableLiveData<TodoDataStatus>){
    view.setOnClickListener {
        todoLiveData.postValue(TodoDataStatus(todoData,TodoStatus.Add))
    }
}

@BindingAdapter("bind:showCalendarDialog")
fun showCalendar(view : Button , calendarDialog: CalendarDialog){
    view.setOnClickListener {
        calendarDialog.show()
    }
}
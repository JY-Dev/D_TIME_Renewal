package com.jydev.d_time_renewal.ui.main.todo.adapter

import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.jydev.d_time_renewal.R
import com.jydev.d_time_renewal.data.Repository
import com.jydev.d_time_renewal.data.TodoRepositoryImpl
import com.jydev.d_time_renewal.databinding.TodoItemBinding
import com.jydev.d_time_renewal.model.TodoData

class TodoAdapter(val todoData : MutableLiveData<TodoData>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    var todoList = mutableListOf<TodoData>(TodoData(0L,"dd","sdf",false),TodoData(0L,"dd","sdf",false),TodoData(0L,"dd","sdf",false))

    inner class TodoViewHolder(private val binding : TodoItemBinding , val context : LifecycleOwner) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : TodoData){
            binding.apply {
                isClear = MutableLiveData<Boolean>().apply {
                    observe(context, Observer {
                        binding.titleTodo.paintFlags = if (it) Paint.STRIKE_THRU_TEXT_FLAG else Paint.HINTING_OFF
                        todoData.postValue(item.apply {
                            isClear = it
                        })
                    })
                }
                todo = item
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : TodoViewHolder = DataBindingUtil.inflate<TodoItemBinding>(
        LayoutInflater.from(parent.context), R.layout.todo_item , parent , false).let {
        TodoViewHolder(it,parent.context as AppCompatActivity)
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todoList[position])
    }
}
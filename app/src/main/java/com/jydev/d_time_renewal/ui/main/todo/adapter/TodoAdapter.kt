package com.jydev.d_time_renewal.ui.main.todo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.jydev.d_time_renewal.R
import com.jydev.d_time_renewal.databinding.TodoItemBinding
import com.jydev.d_time_renewal.model.todo.TodoData
import com.jydev.d_time_renewal.model.todo.TodoDataStatus

class TodoAdapter(val todoData : MutableLiveData<TodoDataStatus>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    var todoList = mutableListOf<TodoData>()

    inner class TodoViewHolder(private val binding : TodoItemBinding , val context : LifecycleOwner) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : TodoData){
            binding.apply {
                todoLiveData = todoData
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
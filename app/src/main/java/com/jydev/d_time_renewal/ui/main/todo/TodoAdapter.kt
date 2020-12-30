package com.jydev.d_time_renewal.ui.main.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jydev.d_time_renewal.R
import com.jydev.d_time_renewal.databinding.TodoItemBinding
import com.jydev.d_time_renewal.model.TodoData

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    var todoList = mutableListOf<TodoData>()
    inner class TodoViewHolder(private val binding : TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : TodoData){
            binding.apply {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : TodoViewHolder = DataBindingUtil.inflate<TodoItemBinding>(
        LayoutInflater.from(parent.context), R.layout.todo_item , parent , false).let {
        TodoViewHolder(it)
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        
    }
}
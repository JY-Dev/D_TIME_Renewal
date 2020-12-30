package com.jydev.d_time_renewal.ui.main.todo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.jydev.d_time_renewal.R
import com.jydev.d_time_renewal.base.BaseFragment
import com.jydev.d_time_renewal.data.Repository
import com.jydev.d_time_renewal.data.TodoRepositoryImpl
import com.jydev.d_time_renewal.databinding.FragmentTodoBinding
import com.jydev.d_time_renewal.model.TodoData
import com.jydev.d_time_renewal.ui.main.todo.adapter.TodoAdapter
import org.koin.android.ext.android.inject
import org.koin.core.KoinComponent


class TodoFragment : BaseFragment() {
    private val todoData = MutableLiveData<TodoData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        todoData.update(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // repository.insert(TodoData(0,"asdf","asdf",false))
        val binding = DataBindingUtil.inflate<FragmentTodoBinding>(inflater,R.layout.fragment_todo,container,false).apply {
            adapter = TodoAdapter(todoData)
        }
        return binding.root
    }

    private fun MutableLiveData<TodoData>.update(lifecycle: LifecycleOwner){
        observe(lifecycle, Observer {

        })
    }
}
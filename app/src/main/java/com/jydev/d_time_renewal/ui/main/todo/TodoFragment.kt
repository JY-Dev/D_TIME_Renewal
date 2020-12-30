package com.jydev.d_time_renewal.ui.main.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jydev.d_time_renewal.R
import com.jydev.d_time_renewal.base.BaseFragment
import com.jydev.d_time_renewal.databinding.FragmentTodoBinding
import com.jydev.d_time_renewal.ui.main.todo.adapter.TodoAdapter


class TodoFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTodoBinding>(inflater,R.layout.fragment_todo,container,false).apply {
            adapter = TodoAdapter()
        }
        return binding.root
    }

}
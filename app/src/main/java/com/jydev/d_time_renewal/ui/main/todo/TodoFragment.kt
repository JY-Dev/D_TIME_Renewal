package com.jydev.d_time_renewal.ui.main.todo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.jydev.d_time_renewal.R
import com.jydev.d_time_renewal.base.BaseFragment
import com.jydev.d_time_renewal.databinding.FragmentTodoBinding
import com.jydev.d_time_renewal.model.todo.TodoData
import com.jydev.d_time_renewal.model.todo.TodoDataStatus
import com.jydev.d_time_renewal.model.todo.TodoStatus
import com.jydev.d_time_renewal.ui.dialog.CalendarDialog
import com.jydev.d_time_renewal.ui.main.todo.adapter.TodoAdapter
import com.jydev.d_time_renewal.util.getDate
import java.util.*


class TodoFragment : BaseFragment<TodoData>() {

    lateinit var todoItemDecoration: TodoItemDecoration
    lateinit var todoAdapter: TodoAdapter
    lateinit var dialog : CalendarDialog
    val viewModel: TodoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.todoStatusData.statusTodoObserve(this)
        viewModel.calendarLiveData.calendarObserve(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        todoItemDecoration = TodoItemDecoration(context)
        dialog = CalendarDialog(context,viewModel.calendarLiveData)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTodoBinding>(inflater,R.layout.fragment_todo,container,false).apply {
            adapter = TodoAdapter(viewModel.todoStatusData).apply {
                todoAdapter = this
                viewModel.calendarLiveData.postValue(Calendar.getInstance())
            }
            itemDecoration = todoItemDecoration
            todoViewModel = viewModel
            calendarDidalog = dialog
        }
        return binding.root
    }

    /**
     * TodoData 작업상태 Observe
     */
    private fun MutableLiveData<TodoDataStatus>.statusTodoObserve(lifecycle: LifecycleOwner){
        observe(lifecycle, Observer {
            when(it.status){
                is TodoStatus.Delete -> it.todoData.delete()
                is TodoStatus.Update -> it.todoData.update()
                is TodoStatus.Add -> it.todoData.insert()
            }
            refreshTodoList(viewModel.calendarLiveData.value!!.getDate())
        })
    }

    /**
     * 캘린더 상태
     */
    private fun MutableLiveData<Calendar>.calendarObserve(lifecycle: LifecycleOwner){
        observe(lifecycle , Observer {
            dialog.dismiss()
            refreshTodoList(it.getDate())
        })
    }

    /**
     * View 갱신
     */
    private fun refreshTodoList(date:String){
        todoAdapter.run {
            todoList = date.getDataFromDate()
            notifyDataSetChanged()
        }
    }

    /**
     * Room DataBase
     * insert
     * update
     * delete
     * getData(전체 데이터 가져오기)
     */
    override fun TodoData.insert() = repository.insert(this)
    override fun TodoData.update() = repository.update(this)
    override fun TodoData.delete() = repository.delete(this)
    override fun getData() = repository.getData()
    override fun String.getDataFromDate() = repository.getData().filter { it.date == this }.toMutableList()
}
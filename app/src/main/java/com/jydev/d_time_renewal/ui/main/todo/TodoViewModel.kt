package com.jydev.d_time_renewal.ui.main.todo

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jydev.d_time_renewal.model.todo.TodoData
import com.jydev.d_time_renewal.model.todo.TodoDataStatus
import com.jydev.d_time_renewal.model.todo.TodoStatus
import com.jydev.d_time_renewal.util.getDate
import java.util.*

class TodoViewModel : ViewModel() {
    val todoStatusData = MutableLiveData<TodoDataStatus>()
    val text = ObservableField<String>()
    var calendarLiveData = MutableLiveData<Calendar>()

    fun addTodoData(view : View){
        text.run {
            get()?.run {
                if (isNotEmpty())
                    todoStatusData.postValue(TodoDataStatus(TodoData(System.currentTimeMillis(),calendarLiveData.value!!.getDate(),this,false),TodoStatus.Add))
            }
            set("")
        }
    }
}
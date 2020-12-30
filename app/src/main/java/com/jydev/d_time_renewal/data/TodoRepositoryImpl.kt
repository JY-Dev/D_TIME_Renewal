package com.jydev.d_time_renewal.data

import com.jydev.d_time_renewal.data.room.TodoDao
import com.jydev.d_time_renewal.model.TodoData

class TodoRepositoryImpl(val todoDao: TodoDao) : Repository<TodoData> {
    override fun insert(data: TodoData) {
        todoDao.insert(data)
    }

    override fun update(data: TodoData) {
        todoDao.updateTodoData(data)
    }

    override fun delete(data: TodoData) {
        todoDao.deleteTodoData(data)
    }

    override fun getData(): MutableList<TodoData> {
        return todoDao.getTodoAllData()
    }


}
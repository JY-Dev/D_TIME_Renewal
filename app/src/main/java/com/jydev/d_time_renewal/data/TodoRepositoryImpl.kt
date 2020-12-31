package com.jydev.d_time_renewal.data

import com.jydev.d_time_renewal.data.room.TodoDao
import com.jydev.d_time_renewal.model.todo.TodoData

class TodoRepositoryImpl(val todoDao: TodoDao) : Repository<TodoData> {
    override fun insert(data: TodoData) =
        todoDao.insert(data)

    override fun update(data: TodoData) =
        todoDao.update(data)

    override fun delete(data: TodoData) =
        todoDao.delete(data)

    override fun getData(): MutableList<TodoData> =
        todoDao.getTodoAllData()

}
package com.jydev.d_time_renewal.data.room

import androidx.room.*
import com.jydev.d_time_renewal.model.TodoData

@Dao
interface TodoDao {

    /**
     * Get All TodoData
     */
    @Query("SELECT * FROM TodoData")
    fun getTodoAllData() : MutableList<TodoData>

    /**
     * Get Express TodoData
     */
    @Query("SELECT * FROM TodoData WHERE `date` =:date")
    fun getTodoData(date:String) : MutableList<TodoData>

    /**
     * Update Certain TodoData
     */
    @Update
    fun updateTodoData(vararg todoData : TodoData)

    /**
     * Insert TodoData
     */
    @Insert
    fun insert(vararg todoData: TodoData)

    /**
     * Delete TodoData
     */
    @Delete
    fun deleteTodoData(vararg todoData : TodoData)
}
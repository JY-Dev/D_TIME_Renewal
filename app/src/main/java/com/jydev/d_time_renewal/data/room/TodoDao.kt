package com.jydev.d_time_renewal.data.room

import androidx.room.*
import com.jydev.d_time_renewal.model.todo.TodoData

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
    fun getTodo(date:String) : MutableList<TodoData>

    /**
     * Update Certain TodoData
     */
    @Update
    fun update(vararg todoData : TodoData)

    /**
     * Insert TodoData
     */
    @Insert
    fun insert(vararg todoData: TodoData)

    /**
     * Delete TodoData
     */
    @Delete
    fun delete(vararg todoData : TodoData)
}
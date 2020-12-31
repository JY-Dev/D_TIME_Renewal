package com.jydev.d_time_renewal.model.todo

/**
 * TodoData의 작업 상태를 관리하기 위한 data class
 */
data class TodoDataStatus(
    val todoData: TodoData,
    val status : TodoStatus
)

/**
 * TodoData의 작업 상태
 */
sealed class TodoStatus{
    object Update : TodoStatus()
    object Delete : TodoStatus()
    object Add : TodoStatus()
}
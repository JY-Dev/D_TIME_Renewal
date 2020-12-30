package com.jydev.d_time_renewal.data

interface Repository<T> {
    fun insert(data : T)
    fun update(data : T)
    fun delete(data : T)
    fun getData() : MutableList<T>
}
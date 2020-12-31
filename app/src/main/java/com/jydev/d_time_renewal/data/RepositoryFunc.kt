package com.jydev.d_time_renewal.data

interface RepositoryFunc<T> {
    fun T.insert()
    fun T.update()
    fun T.delete()
    fun getData() : MutableList<T>
    fun String.getDataFromDate() : MutableList<T>
}
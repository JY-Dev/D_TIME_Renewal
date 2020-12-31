package com.jydev.d_time_renewal.base

import androidx.fragment.app.Fragment
import com.jydev.d_time_renewal.data.Repository
import com.jydev.d_time_renewal.data.RepositoryFunc
import com.jydev.d_time_renewal.model.DataModel
import org.koin.android.ext.android.inject

abstract class BaseFragment<T : DataModel> : Fragment() , RepositoryFunc<T>{
    val repository : Repository<T> by inject()
}
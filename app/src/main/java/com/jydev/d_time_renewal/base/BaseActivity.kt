package com.jydev.d_time_renewal.base

import android.app.Activity
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity : AppCompatActivity() {
    /**
     * DataBinding
     */
    protected inline fun <reified T : ViewDataBinding> binding(resId: Int) : Lazy<T> =
        lazy{ DataBindingUtil.setContentView<T>(this,resId)}

    /**
     * 토스트
     */
    fun String.showLongToast() = Toast.makeText(applicationContext,this,Toast.LENGTH_LONG).show()
    fun String.showShortToast() = Toast.makeText(applicationContext,this,Toast.LENGTH_SHORT).show()

    /**
     * Start Activity
     */
    protected inline fun <reified T : BaseActivity> startActivity(activity : Activity){
        startActivity(Intent(activity,this::class.java))
        finish()
    }

    protected inline fun <reified T : BaseActivity> startActivity(activity : Activity , delay : Long){
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(activity,T::class.java))
            finish()
        },delay)
    }
}
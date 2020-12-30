package com.jydev.d_time_renewal.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.jydev.d_time_renewal.R
import com.jydev.d_time_renewal.base.BaseActivity
import com.jydev.d_time_renewal.ui.main.MainActivity

class SplashActivity : BaseActivity() {
    private val DELAY_TIME = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        gotoMain()
    }

    private fun gotoMain() = startActivity<MainActivity>(this, DELAY_TIME)
}
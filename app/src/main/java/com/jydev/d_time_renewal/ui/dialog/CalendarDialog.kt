package com.jydev.d_time_renewal.ui.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import androidx.lifecycle.MutableLiveData
import com.jydev.d_time_renewal.R
import com.jydev.d_time_renewal.ui.customview.CalendarView
import java.util.*

class CalendarDialog(context: Context , liveData: MutableLiveData<Calendar>) : Dialog(context){
    init {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.setContentView(R.layout.dialog_cal)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        this.setCanceledOnTouchOutside(false)
        findViewById<CalendarView>(R.id.cal_view).apply {
            setCalData(liveData)
        }
    }
}
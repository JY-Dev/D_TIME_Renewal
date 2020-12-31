package com.jydev.d_time_renewal.util

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.getDate() : String = SimpleDateFormat("yyyy.MM.dd",Locale.KOREA).format(time)
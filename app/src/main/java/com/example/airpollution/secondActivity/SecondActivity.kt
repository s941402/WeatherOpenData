package com.example.airpollution.secondActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.airpollution.R
import com.example.airpollution.commonUtil.StaticVariable.INTENT_WEATHER_DATA
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        getIntentData()
    }

    /** 取得 intent extra 資料  */
    private fun getIntentData() {
       val data = intent.getStringExtra(INTENT_WEATHER_DATA)
        tvSecondActivityData.text = data
    }

}
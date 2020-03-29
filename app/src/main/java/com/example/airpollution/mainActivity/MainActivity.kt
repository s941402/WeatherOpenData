package com.example.airpollution.mainActivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.airpollution.R
import com.example.airpollution.adapter.WeatherDataAdapter
import com.example.airpollution.commonUtil.StaticVariable.INTENT_WEATHER_DATA
import com.example.airpollution.commonUtil.StaticVariable.IS_LOGIN
import com.example.airpollution.commonUtil.StaticVariable.SHARED_PREFERENCES
import com.example.airpollution.commonUtil.showToast
import com.example.airpollution.model.WeatherTime
import com.example.airpollution.secondActivity.SecondActivity
import com.example.airpollution.viewInterface.WeatherItemClickListener
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity(), WeatherItemClickListener {

    private val weatherViewModel: WeatherViewModel by viewModel()
    private val userInfoAdapter =
        WeatherDataAdapter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        readData()
        initView()
        observeViewModelData()
    }

    private fun initView() {
        rvOpenDataList.adapter = userInfoAdapter
    }

    private fun readData() {
        val settings = getSharedPreferences(SHARED_PREFERENCES, 0)
        val isLogin = settings.getBoolean(IS_LOGIN, false)
        if (isLogin) showToast(this, getString(R.string.app_welcome)) else saveData()
    }

    private fun saveData() {
        val settings = getSharedPreferences(SHARED_PREFERENCES, 0)
        settings.edit()
            .putBoolean(IS_LOGIN, true)
            .apply()
    }

    private fun observeViewModelData() {
        weatherViewModel.weatherLiveData.observe(this, Observer {
            userInfoAdapter.submitList(it)
        })
    }

    override fun onItemClicked(weatherTime: WeatherTime?, data: String) {
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
            .putExtra(INTENT_WEATHER_DATA, data)
        startActivity(intent)
    }
}


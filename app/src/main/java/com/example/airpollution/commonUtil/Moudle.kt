package com.example.airpollution.commonUtil

import com.example.airpollution.mainActivity.WeatherRepository
import com.example.airpollution.mainActivity.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val myModule = module {
    viewModel { WeatherViewModel(get()) }
}

val repoModule = module {
    single { WeatherRepository() }
}
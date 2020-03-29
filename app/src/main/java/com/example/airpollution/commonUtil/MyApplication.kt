package com.example.airpollution.commonUtil

import android.app.Application
import com.example.airpollution.commonUtil.myModule
import com.example.airpollution.commonUtil.repoModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // Android context
            androidContext(this@MyApplication)
            // modules
            val list = listOf(
                myModule,
                repoModule
            )
            modules(list)
        }
    }
}
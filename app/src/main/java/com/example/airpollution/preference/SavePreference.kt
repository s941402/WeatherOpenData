package com.example.airpollution.preference

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class SavePreference (
    private val sharedPreferences: SharedPreferences,
    private val key: String,
    private val defaultValue: String? = null
) : ReadWriteProperty<Any, String?> {

    override fun getValue(thisRef: Any, property: KProperty<*>): String? =
        sharedPreferences.getString(key, defaultValue)

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String?) =
        sharedPreferences.edit()
            .putString(key, defaultValue)
            .apply()
}

fun SharedPreferences.string(key: String, defaultValue: String? = null): ReadWriteProperty<Any, String?> =
    SavePreference(this, key, defaultValue)
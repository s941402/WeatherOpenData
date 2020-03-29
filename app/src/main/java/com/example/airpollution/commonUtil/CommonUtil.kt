package com.example.airpollution.commonUtil

import android.content.Context
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import com.example.airpollution.R

fun setImageView(mContext: Context, url: String, imageView: AppCompatImageView) {
    GlideApp.with(mContext)
        .load(url)
        .skipMemoryCache(true)
        .placeholder(R.drawable.ic_launcher_background)
        .into(imageView)
}

fun setLocation(): MutableList<String> {
    return mutableListOf("臺北市")
}

/***
 * 統一管理 Toast 訊息，以免發生 Toast 交疊狀況
 * @param mContext
 * @param msg
 * @param duration
 */
fun showToast(mContext: Context, msg: String) {
    Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show()
}


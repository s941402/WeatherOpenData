package com.example.airpollution.viewHolder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.airpollution.commonUtil.StaticVariable.IMAGE_URL_PATH
import com.example.airpollution.commonUtil.setImageView
import kotlinx.android.synthetic.main.adapter_image_item.view.*

class WeatherImageItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(mContext: Context) {
        setImageView(mContext, IMAGE_URL_PATH, itemView.ivImage)
    }
}
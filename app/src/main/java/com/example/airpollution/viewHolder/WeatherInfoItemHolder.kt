package com.example.airpollution.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.airpollution.model.WeatherTime
import com.example.airpollution.viewInterface.WeatherItemClickListener
import kotlinx.android.synthetic.main.adapter_data_item.view.*

class WeatherInfoItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(weatherTime: WeatherTime?, clickListener: WeatherItemClickListener) {
        val startTime = weatherTime?.startTime
        val endTime = weatherTime?.endTime
        val parameter =
            weatherTime?.parameter?.parameterName + weatherTime?.parameter?.parameterUnit
        val data = StringBuilder()
            .append(startTime)
            .append("\n")
            .append(endTime)
            .append("\n")
            .append(parameter)
        itemView.tvSingleData.text = data

        itemView.setOnClickListener {
            clickListener.onItemClicked(weatherTime, data.toString())
        }
    }
}
package com.example.airpollution.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.airpollution.R
import com.example.airpollution.model.WeatherTime
import com.example.airpollution.viewHolder.WeatherImageItemHolder
import com.example.airpollution.viewHolder.WeatherInfoItemHolder
import com.example.airpollution.viewInterface.WeatherItemClickListener

class WeatherDataAdapter(
    private val mContext: Context,
    private val itemClickListener: WeatherItemClickListener
) :
    PagedListAdapter<WeatherTime, RecyclerView.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == 1) {
            val weatherImageView = inflater.inflate(R.layout.adapter_image_item, parent, false)
            WeatherImageItemHolder(weatherImageView)
        } else {
            val weatherDataView = inflater.inflate(R.layout.adapter_data_item, parent, false)
            WeatherInfoItemHolder(weatherDataView)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val weatherInfoModel = getItem(position)
        when (holder) {
            is WeatherImageItemHolder -> holder.bind(mContext)
            is WeatherInfoItemHolder -> holder.bind(weatherInfoModel, itemClickListener)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.viewType ?:1
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<WeatherTime>() {
            override fun areItemsTheSame(oldItem: WeatherTime, newItem: WeatherTime): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: WeatherTime, newItem: WeatherTime): Boolean =
                oldItem == newItem
        }
    }
}
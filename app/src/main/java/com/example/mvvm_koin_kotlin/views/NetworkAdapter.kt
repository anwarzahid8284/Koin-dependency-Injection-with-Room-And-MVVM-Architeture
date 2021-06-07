package com.example.mvvm_koin_kotlin.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_koin_kotlin.network.NetworkData
import com.example.mvvm_koin_kotlin.R

class NetworkAdapter : RecyclerView.Adapter<NetworkAdapter.NetworkVHolder>() {
    var dataList = ArrayList<NetworkData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NetworkVHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.data_item, parent, false)
        return NetworkVHolder(itemView)
    }

    override fun onBindViewHolder(holder: NetworkVHolder, position: Int) {
        holder.titleText.text = dataList[position].title
        holder.bodyText.text = dataList[position].body
    }

    override fun getItemCount(): Int =dataList.size

    inner class NetworkVHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText = itemView.findViewById(R.id.titleID) as TextView
        val bodyText = itemView.findViewById(R.id.bodyID) as TextView
        private val imageView = itemView.findViewById(R.id.imageViewID) as ImageView

        init {
            imageView.setOnClickListener {
                (itemView.context as NetworkActivity).itemClick(it,adapterPosition)
            }
        }

    }
    interface OnItemClickListener{
        fun itemClick(view: View,position: Int)
    }
    fun addUserList(networkList:List<NetworkData>){
        dataList.clear()
        dataList.addAll(networkList)
        notifyDataSetChanged()
    }
}
package com.example.mvvm_koin_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.data_item.view.*

class DataAdatptar(private val dataList: List<DataModel>,private val listener:OnItemClickListener) :
    RecyclerView.Adapter<DataAdatptar.DataVHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataVHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.data_item, parent, false)
        return DataVHolder(itemView)
    }

    override fun onBindViewHolder(holder: DataVHolder, position: Int) {
        holder.numberText.text=dataList[position].userName
        holder.messageText.text=dataList[position].userDesignation
    }

    override fun getItemCount(): Int = dataList.size
    inner class DataVHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val numberText = itemView.findViewById(R.id.nameID) as TextView
            val messageText = itemView.findViewById(R.id.designationID) as TextView
            val imageView=itemView.findViewById(R.id.imageViewID) as ImageView
            init {
                imageView.setOnClickListener {
                    listener.itemClick(it,adapterPosition)
                }
            }

    }
    interface OnItemClickListener{
        fun itemClick(view: View,position: Int)
    }
}
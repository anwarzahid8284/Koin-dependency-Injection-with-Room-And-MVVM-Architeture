package com.example.mvvm_koin_kotlin.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_koin_kotlin.R
import com.example.mvvm_koin_kotlin.room.DataModel

class DataAdatptar :
    RecyclerView.Adapter<DataAdatptar.DataVHolder>() {
     var dataList=ArrayList<DataModel>()
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
                    (itemView.context as MainActivity).itemClick(it,adapterPosition)
                }
            }

    }
    interface OnItemClickListener{
        fun itemClick(view: View,position: Int)
    }
    fun addUserList(userList:List<DataModel>){
        dataList.clear()
        dataList.addAll(userList)
        notifyDataSetChanged()
    }
}
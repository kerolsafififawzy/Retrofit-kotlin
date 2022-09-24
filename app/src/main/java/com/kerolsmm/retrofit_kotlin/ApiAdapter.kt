package com.kerolsmm.retrofit_kotlin

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kerolsmm.retrofit_kotlin.Data.PostModel

class ApiAdapter(var arrayList: ArrayList<PostModel>) : RecyclerView.Adapter<ApiAdapter.ApiViewHolder>() {


    class ApiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
          val textView = itemView.findViewById<TextView>(R.id.textView)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder =
       ApiViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.api_layout,parent,false))

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
         val item = arrayList[position]
         holder.textView.text = item.id + "\n" + item.text
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setArray (arrayList: ArrayList<PostModel>) {
        this.arrayList = arrayList
        notifyDataSetChanged()
    }

}
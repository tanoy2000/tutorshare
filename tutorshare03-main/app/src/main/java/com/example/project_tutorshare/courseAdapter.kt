package com.example.project_tutorshare

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class courseAdapter(val item:List<student_data>, val context: Context):RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view_item = LayoutInflater.from(parent.context).inflate(R.layout.activity_student_main,parent,false)
        return ViewHolder(view_item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.btname.text = item[position].name
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
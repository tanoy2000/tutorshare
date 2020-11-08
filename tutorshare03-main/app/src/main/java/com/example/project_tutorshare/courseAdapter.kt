package com.example.project_tutorshare

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.course_item.view.*

class courseAdapter(val item:List<course_data>, val context: Context):RecyclerView.Adapter<courseAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view_item = LayoutInflater.from(parent.context).inflate(R.layout.activity_stu_home,parent,false)
        val courseHolder = ViewHolder(view_item)

        view_item.setOnClickListener(){
            val pos = courseHolder.adapterPosition
            val context = parent.context
            val course = item[pos]
            val intent = Intent(context,stu_home::class.java)
            intent.putExtra("nameCourse",course.name_course)
            intent.putExtra("nameTutor",course.name_tutor)
            intent.putExtra("telTutor",course.tel_tutor)
            intent.putExtra("emailTutor",course.email_tutor)
            intent.putExtra("priceCourse",course.price_course)
            intent.putExtra("detailCourse",course.detail_course)
            context.startActivity(intent)
        }
        return  courseHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.btname.text = item[position].name_course
    }

    override fun getItemCount(): Int {
        return item.size
    }
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val btname = view.btncourse_detail

    }
}
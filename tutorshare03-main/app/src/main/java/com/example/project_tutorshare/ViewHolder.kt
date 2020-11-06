package com.example.project_tutorshare

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.course_item.view.*

class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val btname =view.btncourse_detail
    val imgTutor = view.img_tutor

}
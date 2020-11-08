package com.example.project_tutorshare

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_stu_course_detail.*

class stu_course_detail : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stu_course_detail)

        val nameCourse =intent.getStringExtra("nameCourse")
        val nameTutor =intent.getStringExtra("nameTutor")
        val telTutor =intent.getStringExtra("telTutor")
        val emailTutor =intent.getStringExtra("emailTutor")
        val priceCourse =intent.getStringExtra("priceCourse")
        val detailCourse =intent.getStringExtra("detailCourse")
        name_course.text = "Course name: $nameCourse"
        name_tutor.text = "Tutor name: $nameTutor"
        tel_tutor.text = "Tel: $telTutor"
        email_tutor.text = "Email: $emailTutor"
        price_course.text = "Price: $priceCourse B"
        detail_course.text = "Detail: $detailCourse"

    }

}
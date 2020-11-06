package com.example.project_tutorshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import kotlinx.android.synthetic.main.activity_login_stu.*

class login_stu : AppCompatActivity() {
    var studentList = arrayListOf<student_data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_stu)
    }
    fun gologged(view: View){
        val username = edit_username.text.toString()
        val pass = edit_pass.text.toString()
        for (i in studentList) {
            val userStudent = studentList[2].toString()
            val passStudent = studentList[3].toString()
            if (username == userStudent) {
                if (pass == passStudent) {
                    setContentView(R.layout.activity_student_main)
                }
            }
        }
    }
    fun back(view: View) {
        setContentView(R.layout.activity_main)
    }
    fun regisStu(view: View){
        setContentView(R.layout.activity_register_stu)
    }
}
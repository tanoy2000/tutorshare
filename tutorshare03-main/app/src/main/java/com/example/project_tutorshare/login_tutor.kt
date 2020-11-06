package com.example.project_tutorshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class login_tutor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_tutor)


    }

    fun back(view: View) {
        setContentView(R.layout.activity_main)
    }
    fun regisTutor(view: View){
        setContentView(R.layout.activity_register_tutor)
    }
}
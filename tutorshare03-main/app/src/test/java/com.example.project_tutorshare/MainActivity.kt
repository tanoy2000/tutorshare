package com.example.test_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_register_stu.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
    fun registerStudent(view: View) {
        val createClient = API.create()
        createClient.regisStd(
                edit_name.text.toString(),
                edit_username.text.toString(),
                edit_password.text.toString(),
                edit_email.text.toString(),
                edit_tel.text.toString()
        ).enqueue(object : Callback<student_data> {
            override fun onResponse(call: Call<student_data>, response: Response<student_data>) {
                if (response.isSuccessful()) {
                    Toast.makeText(
                            applicationContext,
                            "Successfully Registered",
                            Toast.LENGTH_LONG
                    ).show()
                    setContentView(R.layout.activity_login_stu)
                } else {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<student_data>, t: Throwable) {
                Toast.makeText(applicationContext,"Error onFailure" + t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
    fun regisStu(view: View){
        setContentView(R.layout.activity_register_stu)
    }

    fun regisTutor(view: View){
        setContentView(R.layout.activity_register_tutor)
    }

    fun loginstu(view: View){
        setContentView(R.layout.activity_login_stu)
    }
    fun logintutor(view: View){
        setContentView(R.layout.activity_login_tutor)
    }

}
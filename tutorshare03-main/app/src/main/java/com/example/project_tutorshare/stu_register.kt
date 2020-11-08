package com.example.project_tutorshare

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.project_tutorshare.API
import com.example.project_tutorshare.R
import com.example.project_tutorshare.student_data
import kotlinx.android.synthetic.main.activity_stu_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class stu_register : AppCompatActivity() {
    var createClient = API.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stu_register)
    }

    fun check_regisstd(view: View){
        var n = 0
        val edt_usr_name = edit_username.text.toString()
        val edt_email = edit_email.text.toString()
        createClient.retrieveStudent()
            .enqueue(object :Callback<List<student_data>>{
                override fun onResponse(call: Call<List<student_data>>, response: Response<List<student_data>>) {
                    response.body()?.forEach{
                        if (it.username == edt_usr_name || it.email == edt_email){
                            if(n == 0) {
                                n++
                            }
                        }

                    }
                    if(n == 0){
                        registerStudent(view)
                        setContentView(R.layout.activity_stu_login)
                    }

                }

                override fun onFailure(call: Call<List<student_data>>, t: Throwable) {
                    return t.printStackTrace()
                }
            })
    }

    fun registerStudent(view: View) {

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
                    setContentView(R.layout.activity_stu_login)
                } else {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<student_data>, t: Throwable) {
                Toast.makeText(applicationContext,"Error onFailure" + t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
    
    fun loginstu(view: View){
        setContentView(R.layout.activity_stu_login)
    }
}
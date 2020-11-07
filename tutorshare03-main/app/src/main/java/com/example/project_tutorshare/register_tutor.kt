package com.example.project_tutorshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_register_tutor.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class register_tutor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_tutor)
    }

    fun registerTutor(view: View) {
        val createClient = API.create()
        createClient.regisTutor(
                edit_name_tu.text.toString(),
                edit_username_tu.text.toString(),
                edit_password_tu.text.toString(),
                edit_email_tu.text.toString(),
                edit_tel_tu.text.toString()
        ).enqueue(object : Callback<tutor_data> {
            override fun onResponse(call: Call<tutor_data>, response: Response<tutor_data>) {
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

            override fun onFailure(call: Call<tutor_data>, t: Throwable) {
                Toast.makeText(applicationContext,"Error onFailure" + t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun logintutor(view: View){
        setContentView(R.layout.activity_login_tutor)
    }
}
package com.example.project_tutorshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_stu_register.*

import kotlinx.android.synthetic.main.activity_tutor_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class tutor_register : AppCompatActivity() {
    val createClient = API.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutor_register)
    }

    fun check_regisTu(view: View){
        var n = 0
        val edt_usr_name = edit_username_tu.text.toString()
        val edt_email = edit_email_tu.text.toString()
        createClient.retrieveTutor()
            .enqueue(object :Callback<List<tutor_data>>{
                override fun onResponse(call: Call<List<tutor_data>>, response: Response<List<tutor_data>>) {
                    response.body()?.forEach{
                        if (it.username_tu == edt_usr_name || it.email_tu == edt_email){
                            if(n == 0) {
                                n++
                            }
                        }

                    }
                    if(n == 0){
                        registerTutor(view)
                        setContentView(R.layout.activity_tutor_login)
                    }

                }

                override fun onFailure(call: Call<List<tutor_data>>, t: Throwable) {
                    return t.printStackTrace()
                }


            })
    }

    fun registerTutor(view: View) {

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
                    setContentView(R.layout.activity_stu_login)
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
        setContentView(R.layout.activity_tutor_login)
    }
}
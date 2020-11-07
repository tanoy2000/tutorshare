package com.example.project_tutorshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_stu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_register_stu.*
import kotlinx.android.synthetic.main.activity_register_stu.edit_username
import kotlinx.android.synthetic.main.activity_register_tutor.*


class MainActivity : AppCompatActivity() {
    var studentList = arrayListOf<student_data>()
    var createClient = API.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun loggedstd(view: View){
        val edt_usr_name = log_username.text.toString()
        val edt_pass = log_pass.text.toString()
        createClient.retrieveStudent()
                .enqueue(object :Callback<List<student_data>>{
            override fun onResponse(call: Call<List<student_data>>, response: Response<List<student_data>>) {
                response.body()?.forEach{
                    if (it.username == edt_usr_name && it.password == edt_pass){
                        var loggedUser = it
                        TokenUser(loggedUser)
                        setContentView(R.layout.std_home)
                    }
                }
            }

            override fun onFailure(call: Call<List<student_data>>, t: Throwable) {
                return t.printStackTrace()
            }
        })
    }

    fun TokenUser(array: student_data){

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
                    setContentView(R.layout.activity_login_tutor)
                } else {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<tutor_data>, t: Throwable) {
                Toast.makeText(applicationContext,"Error onFailure" + t.message, Toast.LENGTH_LONG).show()
            }
        })
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

    fun back(view: View) {
        setContentView(R.layout.activity_main)
    }

}
package com.example.project_tutorshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_stu_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_stu_register.*
import kotlinx.android.synthetic.main.activity_stu_register.edit_username
import kotlinx.android.synthetic.main.activity_tutor_register.*


class MainActivity : AppCompatActivity() {
    var studentList = arrayListOf<student_data>()
    var createClient = API.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun loggedstd(view: View){
        val edt_usrname = log_username.text.toString()
        val edt_pass = log_pass.text.toString()
        createClient.retrieveStudent()
                .enqueue(object :Callback<List<student_data>>{
            override fun onResponse(call: Call<List<student_data>>, response: Response<List<student_data>>) {
                response.body()?.forEach{
                    if (it.username == edt_usrname && it.password == edt_pass){
                        var loggedUser = it.id_std.toString()
                        TokenUser(loggedUser)
                        setContentView(R.layout.activity_stu_home)
                    }
                }
            }

            override fun onFailure(call: Call<List<student_data>>, t: Throwable) {
                return t.printStackTrace()
            }
        })
    }

    fun loggedTutor(view: View){
        val edt_usrname_tu = log_username.text.toString()
        val edt_pass_tu = log_pass.text.toString()
        createClient.retrieveTutor()
                .enqueue(object :Callback<List<tutor_data>>{
                    override fun onResponse(call: Call<List<tutor_data>>, response: Response<List<tutor_data>>) {
                        response.body()?.forEach{
                            if (it.username_tu == edt_usrname_tu && it.password_tu == edt_pass_tu){
                                var loggedUser = it.id_tu.toString()
                                TokenUser(loggedUser)
                                setContentView(R.layout.activity_tutor_course)
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<tutor_data>>, t: Throwable) {
                        return t.printStackTrace()
                    }


                })
    }

    fun TokenUser(loggedUser: String) {


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
                    setContentView(R.layout.activity_tutor_login)
                } else {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<tutor_data>, t: Throwable) {
                Toast.makeText(applicationContext,"Error onFailure" + t.message, Toast.LENGTH_LONG).show()
            }
        })
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
    fun regisStu(view: View){
        setContentView(R.layout.activity_stu_register)
    }

    fun regisTutor(view: View){
        setContentView(R.layout.activity_tutor_register)
    }

    fun loginstu(view: View){
        setContentView(R.layout.activity_stu_login)
    }
    fun logintutor(view: View){
        setContentView(R.layout.activity_tutor_login)
    }

    fun back(view: View) {
        setContentView(R.layout.activity_main)
    }


}
package com.example.project_tutorshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_stu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class login_stu : AppCompatActivity() {
    var studentList = arrayListOf<student_data>()
    var createClient = API.create()
    var logUser = arrayListOf<student_data>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_stu)
    }

        fun loggedstd(view: View){
            val edt_usr_name = log_username.text.toString()
            val edt_pass = log_pass.text.toString()
            createClient.retrieveStudent()
                    .enqueue(object : Callback<List<student_data>> {
                override fun onResponse(call: Call<List<student_data>>, response: Response<List<student_data>>) {
                    response.body()?.forEach{
                        if (it.username == edt_usr_name && it.password == edt_pass){

                            TokenUser(edt_usr_name)
                            setContentView(R.layout.std_home)
                        }else{
                            Toast.makeText(applicationContext,"No User data!!", Toast.LENGTH_LONG).show()
                        }
                    }
                }

                override fun onFailure(call: Call<List<student_data>>, t: Throwable) {
                    return t.printStackTrace()
                }
            })
        }

    fun TokenUser(edt_usr_name: String) {

    }

    fun back(view: View) {
        setContentView(R.layout.activity_main)
    }
    fun regisStu(view: View){
        setContentView(R.layout.activity_register_stu)
    }
}
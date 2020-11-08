package com.example.project_tutorshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_stu_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class tutor_login : AppCompatActivity() {
    var createClient = API.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutor_login)


    }
    fun loggedTutor(view: View){
        val edt_usrname_tu = log_username.text.toString()
        val edt_pass_tu = log_pass.text.toString()
        createClient.retrieveTutor()
                .enqueue(object : Callback<List<tutor_data>> {
                    override fun onResponse(call: Call<List<tutor_data>>, response: Response<List<tutor_data>>) {
                        response.body()?.forEach{
                            if (it.username_tu == edt_usrname_tu && it.password_tu == edt_pass_tu){
                                var loggedUser = it.id_tu.toString()
                                TokenTutor(loggedUser)
                                setContentView(R.layout.activity_tutor_course)
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<tutor_data>>, t: Throwable) {
                        return t.printStackTrace()
                    }


                })
    }
    fun TokenTutor(loggedTutor: String) {


    }

    fun back(view: View) {
        setContentView(R.layout.activity_main)
    }
    fun regisTutor(view: View){
        setContentView(R.layout.activity_tutor_register)
    }
}
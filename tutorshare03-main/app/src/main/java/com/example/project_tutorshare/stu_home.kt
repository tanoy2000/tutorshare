package com.example.project_tutorshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_stu_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class stu_home : AppCompatActivity() {
    var courseList = arrayListOf<course_data>()
    val createClient = API.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stu_home)

        recycler_course.layoutManager = LinearLayoutManager(applicationContext)
        recycler_course.addItemDecoration(DividerItemDecoration(recycler_course.context,
        DividerItemDecoration.VERTICAL))
    }

    override fun onResume() {
        super.onResume()
        callCourse()
    }

    fun callCourse(){
        courseList.clear()
        createClient.retrieveCourse()
                .enqueue(object  : Callback<List<course_data>>{
                    override fun onResponse(call: Call<List<course_data>>, response: Response<List<course_data>>) {
                        response.body()?.forEach{
                            courseList.add(course_data(it.id_course,it.name_course,it.name_tutor
                            ,it.tel_tutor,it.email_tutor,it.price_course,it.detail_course))
                        }
                        recycler_course.adapter = courseAdapter(courseList,applicationContext)
                        Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()
                    }

                    override fun onFailure(call: Call<List<course_data>>, t: Throwable) {
                        t.printStackTrace()
                        Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                    }
                })
    }
}
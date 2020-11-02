package com.example.project_tutorshare

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
val createClient = API.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.index)
        var btnstd : Button = findViewById(R.id.btnstudent);
        var btntutor : Button = findViewById(R.id.btntutor);
        btnstd.setOnClickListener{ view->
            setContentView(R.layout.login_stu)
            var btnlogin : Button = findViewById(R.id.loginbtn)
            var btnregis : Button = findViewById(R.id.registerbtn)
            btnregis.setOnClickListener{view ->
                setContentView(R.layout.register_stu)

            }
            btnlogin.setOnClickListener{view ->
                var std_id : EditText = findViewById(R.id.edit_name)
                var std_pass : EditText = findViewById(R.id.edit_pass)

            }
        }
        btntutor.setOnClickListener{ view->
            setContentView(R.layout.login_tutor)
        }



    }

    fun registerStudent(view: View) {
         createClient.regisStd(
            edit_name.text.toString(),
            edit_username.text.toString(),
            edt_password.text.toString(),
            edit_email.text.toStrisg(),
            edit_tel.text.toString()
        ).enqueue(object :Callback<student>{
             override fun onResponse(call: Call<student>, response: Response<student>) {
                 if (response.isSuccessful()) {
                     Toast.makeText(
                         applicationContext,
                         "Successfully Registered",
                         Toast.LENGTH_LONG
                     ).show()
                     finish()
                 } else {
                     Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
                 }
             }

             override fun onFailure(call: Call<student>, t: Throwable) {
                 Toast.makeText(applicationContext,"Error onFailure" + t.message,Toast.LENGTH_LONG).show()
             }
         })
    }
    //if(savedInstanceState==null){
            //supportFragmentManager.beginTransaction().add(
                //R.id.frameLayout,
                //tutor_course()
            //).commit()
        //}
    }
    //fun OnClickShow_stu(view: View){
    //    setContentView(R.layout.show_student)
    //}
    //fun btnCourseDetail(view: View) {
        //supportFragmentManager.beginTransaction().add(
            //R.id.frameLayout,
            //tutor_course_detail()
       // ).commit()
   // }

    //fun btnCourse(view: View){
        //supportFragmentManager.beginTransaction().add(
           // R.id.frameLayout,
           // tutor_course()
      //  ).commit()
    //}

}

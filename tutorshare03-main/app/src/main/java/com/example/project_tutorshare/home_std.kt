package com.example.project_tutorshare


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_student_main.view.*


class home_std : Fragment() {
    var studentList = arrayListOf<student_data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val transaction = childFragmentManager.beginTransaction()

        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.std_home, container, false)

        return view
    }



}
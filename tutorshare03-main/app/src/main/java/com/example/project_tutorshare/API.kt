package com.example.project_tutorshare

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface API {
    @GET("allstd")
    fun retrieveStudent(): Call<List<student_data>>

    @GET("std/{id}")
    fun retrieveStudentUser(
        @Path("id") id_std:Int

    ): Call<List<student_data>>

    @FormUrlEncoded
    @POST("std")
    fun regisStd(
            @Field("name") name: String,
            @Field("username") username: String,
            @Field("password") password: String,
            @Field("email") email: String,
            @Field("tel") tel: String
            ): Call<student_data>



    @GET("alltutor")
    fun retrieveTutor(): Call<List<tutor_data>>

    @GET("tutor/{id_tu}")
    fun retrievetutorUser(
            @Path("id_tu") id_tu:Int

    ): Call<List<tutor_data>>

    @FormUrlEncoded
    @POST("tutor")
    fun regisTutor(
            @Field("name_tu") name_tu :String,
            @Field("username_tu") username_tu :String,
            @Field("password_tu") password_tu :String,
            @Field("email_tu") email_tu :String,
            @Field("tel_tu") tel_tu :String
    ): Call<tutor_data>


    @GET("allcourse")
    fun retrieveCourse(): Call<List<course_data>>

    @GET("course/{id_course}")
    fun retrieveSelectCourse(
            @Path("id_course") id_course:Int

    ): Call<List<course_data>>

    @FormUrlEncoded
    @POST("course")
    fun addCourse(
            @Field("name_course") name_course :String,
            @Field("name_tutor") name_tutor :String,
            @Field("tel_tutor") tel_tutor :String,
            @Field("email_tutor") email_tutor :String,
            @Field("price_tutor") price_course :String
    ): Call<course_data>



    companion object {
        fun create(): API{
            val Client: API = Retrofit.Builder()
                .baseUrl("http:10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(API::class.java)
            return  Client
        }
    }
}
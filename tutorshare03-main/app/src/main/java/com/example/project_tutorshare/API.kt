package com.example.project_tutorshare

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface API {
    @GET("allstd")
    fun retrieveStudent(): Call<List<student_data>>

    @GET("std/{username}")
    fun retrieveStudentUser(
        @Path("username") username:String

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

    @FormUrlEncoded
    @POST("tutor")
    fun regisTutor(
            @Field("name") name_tu :String,
            @Field("username") username_tu :String,
            @Field("password") password_tu :String,
            @Field("email") email_tu :String,
            @Field("tel") tel_tu :String
    ): Call<tutor_data>



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
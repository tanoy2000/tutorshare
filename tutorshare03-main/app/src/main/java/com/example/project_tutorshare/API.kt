package com.example.project_tutorshare

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface API {
    @GET("allstd")
    fun retrieveStudent(): Call<List<student>>

    @GET("std/{username}")
    fun retrieveStudentUser(
        @Path("username") username:String
    ): Call<List<student>>


    @POST("std")
    fun regisStd(
        @Field("name") name :String,
        @Field("username") username :String,
        @Field("password") password :String,
        @Field("email") email :String,
        @Field("tel") tel :String
    ):Call<List<student>>

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
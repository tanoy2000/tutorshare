package com.example.project_tutorshare

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class course_data (
        @Expose
        @SerializedName("id_course") val id_course:Int,

        @Expose
        @SerializedName("name_course") val name_course:String,

        @Expose
        @SerializedName("name_tutor") val name_tutor:String,

        @Expose
        @SerializedName("tel_tutor") val tel_tutor:String,

        @Expose
        @SerializedName("email_tutor") val email_tutor:String,

        @Expose
        @SerializedName("price_course") val price_course:String,

        @Expose
        @SerializedName("detail_course") val detail_course:String

        ){}
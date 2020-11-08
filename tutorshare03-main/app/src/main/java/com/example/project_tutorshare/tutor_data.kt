package com.example.project_tutorshare

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class tutor_data (

        @Expose
        @SerializedName("id_tu") val id_tu: Int,

        @Expose
        @SerializedName("name_tu") val name_tu: String,

        @Expose
        @SerializedName("username_tu") val username_tu: String,

        @Expose
        @SerializedName("password_tu") val password_tu: String,

        @Expose
        @SerializedName("email_tu") val email_tu: String,

        @Expose
        @SerializedName("tel_tu") val tel_tu: String
){}
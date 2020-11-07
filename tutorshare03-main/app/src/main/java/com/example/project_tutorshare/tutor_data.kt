package com.example.project_tutorshare

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class tutor_data (
        @Expose
        @SerializedName("name") val name_tu: String,

        @Expose
        @SerializedName("username") val username_tu: String,

        @Expose
        @SerializedName("password") val password_tu: String,

        @Expose
        @SerializedName("email") val email_tu: String,

        @Expose
        @SerializedName("tel") val tel_tu: String
){}
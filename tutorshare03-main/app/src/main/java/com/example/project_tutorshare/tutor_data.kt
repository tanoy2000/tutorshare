package com.example.project_tutorshare

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class tutor_data (
        @Expose
        @SerializedName("name") val name: String,

        @Expose
        @SerializedName("username") val username: String,

        @Expose
        @SerializedName("password") val password: String,

        @Expose
        @SerializedName("email") val email: String,

        @Expose
        @SerializedName("tel") val tel: String
){}
package com.example.easycloudkotlin.http

import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginService {
    @GET("/api/umse/userManage/sendMsg")
    fun getCaptchaRequest(@Query("phone") phone:String, @Query("validTime") validTime: Int):Call<ResponseBody>

}
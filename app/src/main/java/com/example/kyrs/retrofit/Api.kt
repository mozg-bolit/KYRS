package com.example.kyrs.retrofit

import com.example.kyrs.data.Models.Employee
import com.example.kyrs.data.Models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {
    @GET("employee/{id}")
    suspend fun getEmployeeById(@Path("id")id:Int): Employee

    @POST("user")
    suspend fun sendUser(@Body user: User): Response<User>
}
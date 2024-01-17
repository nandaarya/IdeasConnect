package com.example.ideasconnect.data.retrofit

import com.example.ideasconnect.data.response.*
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @GET("idea-list")
    suspend fun getIdeaList(
        @Header("Authorization") token: String,
    ): GetIdeaListResponse
}
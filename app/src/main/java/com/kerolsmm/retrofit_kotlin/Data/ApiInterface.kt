package com.kerolsmm.retrofit_kotlin.Data

import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("posts")
    suspend fun  mGetData() : ArrayList<PostModel>
    @DELETE("posts/{id}")
    fun  mDelete(@Path("id") id : Int) : Call<PostModel>
    @PUT("posts/{id}")
    fun mPut(@Path("id") id: Int, @Body postModel: PostModel) : Call<PostModel>
    @POST("posts")
    fun  mPost( @Body postModel: PostModel) : Call<PostModel>

}
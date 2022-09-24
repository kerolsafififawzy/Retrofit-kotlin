package com.kerolsmm.retrofit_kotlin.Data


import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ApiCreate() {


     private var apiInterface : ApiInterface

    companion object {

        fun  getInstance () : ApiCreate {
            return ApiCreate()
        }
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiInterface = retrofit.create(ApiInterface::class.java)

    }


          suspend fun mGetApi () : ArrayList<PostModel>{
            return apiInterface.mGetData()
        }

          fun mPostApi (model: PostModel) : Call<PostModel>{
          return apiInterface.mPost(model)
        }

          fun  mDeleteApi (id : Int) : Call<PostModel>{
          return apiInterface.mDelete(id)
       }

         fun  mPutApi (id: Int,model: PostModel) : Call<PostModel>{
         return apiInterface.mPut(id,model)
       }






}
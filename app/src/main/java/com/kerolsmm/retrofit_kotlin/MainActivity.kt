package com.kerolsmm.retrofit_kotlin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.kerolsmm.retrofit_kotlin.Data.ApiCreate
import com.kerolsmm.retrofit_kotlin.Data.PostModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private val TAG : String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mGetBtn = findViewById<MaterialButton>(R.id.GetUserModel)
        mGetBtn.setOnClickListener(View.OnClickListener {

            val intent = Intent(this,ShowActivity::class.java)
            startActivity(intent)

        })

        val mPostBtn = findViewById<MaterialButton>(R.id.Post);
        mPostBtn.setOnClickListener(View.OnClickListener {
                        ApiCreate.getInstance().mPostApi(PostModel(22,"Kerols","Test")).enqueue(object : Callback<PostModel> {
                            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
                                Log.d(TAG, "onResponse: ${response.body()!!.text}")

                            }
                            override fun onFailure(call: Call<PostModel>, t: Throwable) {
                                Log.e(TAG, "onResponse: " , t)
                            }
                        })

        })

        val mPutBtn = findViewById<MaterialButton>(R.id.PUT)
        mPutBtn.setOnClickListener(View.OnClickListener {
                ApiCreate.getInstance().mPutApi(1,PostModel(32,"Kerols","Test")).enqueue(object : Callback<PostModel> {
                    override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
                        Log.d(TAG, "onResponse: ${response.body()!!.id}"  )
                    }

                    override fun onFailure(call: Call<PostModel>, t: Throwable) {
                        Log.e(TAG, "onResponse: " , t)
                    }
                })

        })

        val mDeleteBtn =findViewById<MaterialButton>(R.id.Delete)
        mDeleteBtn.setOnClickListener(View.OnClickListener {

                    ApiCreate.getInstance().mDeleteApi(2).enqueue(object : Callback<PostModel> {
                    override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
                        Log.d(TAG, "onResponse: ${response.body()!!.text}"  )
                    }

                    override fun onFailure(call: Call<PostModel>, t: Throwable) {
                        Log.e(TAG, "onResponse: " , t)

                    }
                })
        })



    }
}
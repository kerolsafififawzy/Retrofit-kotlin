package com.kerolsmm.retrofit_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.kerolsmm.retrofit_kotlin.Data.ApiCreate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class ShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

         val apiViewHolder = ViewModelProvider(this)[ApiViewModel::class.java]
         val recyclerView = findViewById<RecyclerView>(R.id.list)
         val apiAdapter = ApiAdapter(ArrayList())
         recyclerView.adapter = apiAdapter

        lifecycleScope.launchWhenStarted {
            apiViewHolder.stateFlow.collect {
                apiAdapter.setArray(it)
            }
        }



    }
}
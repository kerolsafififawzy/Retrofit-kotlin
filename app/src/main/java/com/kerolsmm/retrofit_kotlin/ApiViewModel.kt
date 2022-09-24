package com.kerolsmm.retrofit_kotlin

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kerolsmm.retrofit_kotlin.Data.ApiCreate
import com.kerolsmm.retrofit_kotlin.Data.PostModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class ApiViewModel(application: Application) : AndroidViewModel(application) {

    var stateFlow : MutableStateFlow<ArrayList<PostModel>> = MutableStateFlow<ArrayList<PostModel>>(ArrayList())

    init {
         viewModelScope.launch {
            try {
                val array: ArrayList<PostModel> = ApiCreate.getInstance().mGetApi()
                stateFlow.value = array
            } catch (re: Exception) {
                Log.e("ApiViewModel", ": ", re)
            }
        }

    }





}
package com.kerolsmm.retrofit_kotlin.Data

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
data class PostModel(
    val userId: Int, val title: String, @field:SerializedName(
        "body"
    ) val text: String
) {
    val id: String? = null

}
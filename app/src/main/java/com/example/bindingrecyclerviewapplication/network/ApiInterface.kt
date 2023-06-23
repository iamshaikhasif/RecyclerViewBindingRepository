package com.example.bindingrecyclerviewapplication.network

import com.example.bindingrecyclerviewapplication.models.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    fun fetchAllPosts(): Call<List<PostModel>>

}
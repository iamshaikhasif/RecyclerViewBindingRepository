package com.example.bindingrecyclerviewapplication.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bindingrecyclerviewapplication.models.PostModel
import com.example.bindingrecyclerviewapplication.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel:ViewModel() {

    var postModelListLiveData : LiveData<List<PostModel>>? = MutableLiveData()

    init {
        postModelListLiveData = fetchAllPosts()
    }

    fun fetchAllPosts():LiveData<List<PostModel>>{
        val data = MutableLiveData<List<PostModel>>()

        val apiInterface by lazy { ApiClient.callApi() }
        apiInterface.fetchAllPosts().enqueue(object : Callback<List<PostModel>> {

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {

                val res = response.body()
                if (response.code() == 200 &&  res!=null){
                    data.value = res
                }else{
                    data.value = null
                }
            }
        })
        return data
    }
}
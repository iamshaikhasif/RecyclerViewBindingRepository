package com.example.bindingrecyclerviewapplication.ui.post

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bindingrecyclerviewapplication.R
import com.example.bindingrecyclerviewapplication.adapter.LargeNewsAdapter
import com.example.bindingrecyclerviewapplication.databinding.ActivityPostBinding
import com.example.bindingrecyclerviewapplication.ui.MainViewModel
import com.example.bindingrecyclerviewapplication.ui.post.adapter.PostAdapter
import com.google.gson.Gson

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding
    private lateinit var context: Context
    private  lateinit var viewModel: PostViewModel
    private  lateinit var postAdapter: PostAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)
        context = this

        viewModel = ViewModelProvider.AndroidViewModelFactory(application).create(PostViewModel::class.java)
        postAdapter = PostAdapter()
        binding.postAdapter = postAdapter

        binding.apply {
            setRvDAta()

            rvPost.setHasFixedSize(true)
        }

    }

    private fun setRvDAta(){

        viewModel.postModelListLiveData?.observe(this, Observer {
            if(it != null){
                postAdapter.setData(it)
            }
        })
    }
}
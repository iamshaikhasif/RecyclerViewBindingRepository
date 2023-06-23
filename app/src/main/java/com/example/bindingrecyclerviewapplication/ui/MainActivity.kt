package com.example.bindingrecyclerviewapplication.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bindingrecyclerviewapplication.R
import com.example.bindingrecyclerviewapplication.adapter.CustomClickListener
import com.example.bindingrecyclerviewapplication.adapter.LargeNewsAdapter
import com.example.bindingrecyclerviewapplication.data.DummyData
import com.example.bindingrecyclerviewapplication.databinding.ActivityMainBinding
import com.example.bindingrecyclerviewapplication.models.LargeNews
import com.example.bindingrecyclerviewapplication.ui.post.PostActivity
import com.google.gson.Gson

class MainActivity : AppCompatActivity(),CustomClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var context: Context
    private  lateinit var viewModel: MainViewModel
    private  lateinit var newsAdapter: LargeNewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        context = this

        viewModel = ViewModelProvider.AndroidViewModelFactory(application).create(MainViewModel::class.java)

        viewModel.getData(context)


        binding.apply {
            setRvDAta()

            btnPost.setOnClickListener {
                startActivity(Intent(context, PostActivity::class.java))
            }
        }

    }

    private fun setRvDAta(){
        viewModel.largeNewsList.observe(this, Observer {
            if(it != null){
                newsAdapter = LargeNewsAdapter(it, context, this)
                binding.myAdapter = newsAdapter
                binding.rvNews.setHasFixedSize(true)
            }
        })
    }




    override fun cardClicked(data: LargeNews) {
        Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show()
    }
}
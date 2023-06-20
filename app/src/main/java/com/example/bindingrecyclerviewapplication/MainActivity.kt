package com.example.bindingrecyclerviewapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bindingrecyclerviewapplication.adapter.LargeNewsAdapter
import com.example.bindingrecyclerviewapplication.data.DummyData
import com.example.bindingrecyclerviewapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var context: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        context = this

        binding.apply {
            val largeNews = DummyData.getDummyData(context)
            val newsAdapter = LargeNewsAdapter(largeNews, context)
            binding.myAdapter = newsAdapter
            binding.rvNews.setHasFixedSize(true)
        }

    }
}
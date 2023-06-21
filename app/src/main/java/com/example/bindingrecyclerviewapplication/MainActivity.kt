package com.example.bindingrecyclerviewapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bindingrecyclerviewapplication.adapter.CustomClickListener
import com.example.bindingrecyclerviewapplication.adapter.LargeNewsAdapter
import com.example.bindingrecyclerviewapplication.data.DummyData
import com.example.bindingrecyclerviewapplication.databinding.ActivityMainBinding
import com.example.bindingrecyclerviewapplication.models.LargeNews

class MainActivity : AppCompatActivity(),CustomClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var context: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        context = this

        val largeNews = DummyData.getDummyData(context)
        val newsAdapter = LargeNewsAdapter(largeNews, context, this)

        binding.apply {
            binding.myAdapter = newsAdapter
            binding.rvNews.setHasFixedSize(true)
        }

    }

    override fun cardClicked(data: LargeNews) {
        Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show()
    }
}
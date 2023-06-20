package com.example.bindingrecyclerviewapplication.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bindingrecyclerviewapplication.databinding.NewLargeItemBinding
import com.example.bindingrecyclerviewapplication.models.LargeNews

class LargeNewsAdapter(
    private val largeNewsList:List<LargeNews>,
    private val context: Context,
) : RecyclerView.Adapter<LargeNewsViewHolder>(), CustomClickListener {

    private lateinit var binding: NewLargeItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LargeNewsViewHolder {
        binding = NewLargeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LargeNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LargeNewsViewHolder, position: Int) {
        val largeNews = largeNewsList[position]
        holder.bind(largeNews)
        holder.binding.itemClickListener = this
    }

    override fun getItemCount(): Int = largeNewsList.size

    override fun cardClicked(data: LargeNews) {
        Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show()
    }
}
package com.example.bindingrecyclerviewapplication.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.bindingrecyclerviewapplication.databinding.NewLargeItemBinding
import com.example.bindingrecyclerviewapplication.models.LargeNews

class LargeNewsViewHolder(
    public val binding: NewLargeItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(largeNews: LargeNews) {
        binding.largeNews = largeNews
    }
}
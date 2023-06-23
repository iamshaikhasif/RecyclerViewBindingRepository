package com.example.bindingrecyclerviewapplication.ui.post.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bindingrecyclerviewapplication.databinding.NewLargeItemBinding
import com.example.bindingrecyclerviewapplication.databinding.PostItemBinding
import com.example.bindingrecyclerviewapplication.models.LargeNews
import com.example.bindingrecyclerviewapplication.models.PostModel

class PostAdapter() : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var post: List<PostModel>? = null

    private lateinit var binding: PostItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.PostViewHolder {
        binding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostAdapter.PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
        val largeNews = post?.get(position)
        holder.bind(largeNews)
    }

    override fun getItemCount(): Int = post?.size ?:0


    class PostViewHolder(
        public val binding: PostItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: PostModel?) {
            binding.post = post
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    public fun setData(data:List<PostModel>){
        post = data
        notifyDataSetChanged()
    }

}
package com.example.bindingrecyclerviewapplication.adapter

import com.example.bindingrecyclerviewapplication.models.LargeNews

interface CustomClickListener {
    fun cardClicked(data: LargeNews)
}
package com.example.bindingrecyclerviewapplication.models

import com.example.bindingrecyclerviewapplication.R

data class PostModel(
    var userId: Int? = 0,
    var id: Int? = 0,
    var title: String? = "",
    var body: String? = "",
    var image: Int? = R.drawable.btwo
)

package com.example.bindingrecyclerviewapplication.data

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.bindingrecyclerviewapplication.R
import com.example.bindingrecyclerviewapplication.models.LargeNews

object DummyData {
    fun getDummyData(context: Context): List<LargeNews> {
        val newsList = arrayListOf<LargeNews>()

        val largeNews1 = LargeNews(
            "Large News Title 1",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim sit amet commodo ornare. Morbi sit amet urna felis.",
            ContextCompat.getDrawable(context, R.drawable.bone)
        )
        val largeNews2 = LargeNews(
            "Large News Title 2",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim sit amet commodo ornare. Morbi sit amet urna felis.",
            ContextCompat.getDrawable(context, R.drawable.btwo)
        )
        val largeNews3 = LargeNews(
            "Large News Title 3",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim sit amet commodo ornare. Morbi sit amet urna felis.",
            ContextCompat.getDrawable(context, R.drawable.btwo)
        )
        val largeNews4 = LargeNews(
            "Large News Title 4",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim sit amet commodo ornare. Morbi sit amet urna felis.",
            ContextCompat.getDrawable(context, R.drawable.bone)
        )

        newsList.add(largeNews1)
        newsList.add(largeNews2)
        newsList.add(largeNews3)
        newsList.add(largeNews4)
        return newsList

    }
}
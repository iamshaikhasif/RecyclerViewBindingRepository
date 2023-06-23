package com.example.bindingrecyclerviewapplication.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bindingrecyclerviewapplication.data.DummyData
import com.example.bindingrecyclerviewapplication.models.LargeNews

class MainViewModel: ViewModel() {
    var largeNews = MutableLiveData<List<LargeNews>>()
    var largeNewsList:LiveData<List<LargeNews>> = largeNews



    public fun getData(context: Context){
        largeNews.value = DummyData.getDummyData(context)
    }


}
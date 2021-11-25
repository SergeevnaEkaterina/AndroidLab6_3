package com.example.task2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope


class MainActivityViewModel: ViewModel() {
    val bitmap: MutableLiveData<Bitmap> = MutableLiveData()
    fun load(name:String) {
        viewModelScope.launch(Dispatchers.IO) {
            val picture = BitmapFactory.decodeStream(URL(name).openConnection().getInputStream())
            bitmap.postValue(picture)
        }
    }

}
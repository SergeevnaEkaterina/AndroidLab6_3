package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.concurrent.ExecutorService

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var image: ImageView
    val pictureUrl: String = "https://www.5top100.ru/upload/iblock/e74/DJI_0300_thumb_ec557adb942b7b6f.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = MainActivityViewModel()
        button = findViewById(R.id.button)
        image = findViewById(R.id.imageView)
        button.setOnClickListener {
            viewModel.load(pictureUrl)
        }
        viewModel.bitmap.observe(this) {
            image.setImageBitmap(it)
        }
    }
}
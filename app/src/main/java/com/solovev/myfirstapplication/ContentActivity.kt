package com.solovev.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Временно пустой экран
class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
    }
}
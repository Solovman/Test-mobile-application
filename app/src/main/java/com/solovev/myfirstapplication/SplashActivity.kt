package com.solovev.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//Тут будет происходить выбор, какое именно активити будет открыто
//при запуске приложения в том или ином сценарии
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}
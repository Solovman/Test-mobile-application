package com.solovev.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//Временно пустой экран, с которым мы будем работать в следующих лабораторных
class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
    }
}
package com.solovev.myfirstapplication

import android.content.Intent
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar

//Тут будет происходить выбор, какое именно активити будет открыто
//при запуске приложения в том или ином сценарии
class SplashActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        progressBar = findViewById(R.id.progress_bar)

        // Логика для перехода на RegistrationActivity.
        Handler().postDelayed(Runnable {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)

    }
}
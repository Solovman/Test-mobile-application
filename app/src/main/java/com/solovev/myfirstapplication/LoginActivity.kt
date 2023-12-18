package com.solovev.myfirstapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val linkToRegistration = findViewById<TextView>(R.id.to_registration_page_label)


        linkToRegistration.setOnClickListener{
            val intent = Intent(this, RegistrationActivity::class.java)

            startActivity(intent)
        }

        val fullText = linkToRegistration.text.toString()

        val startIndex = fullText.indexOf("Регистрация")
        val spannableString = SpannableString(fullText)

        // Установка цвета для слова "войдите"
        val colorSpan = ForegroundColorSpan(resources.getColor(R.color.purple))
        spannableString.setSpan(colorSpan, startIndex, startIndex + "Регистрация".length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        // Установите измененный текст в TextView
        linkToRegistration.text = spannableString
    }
}
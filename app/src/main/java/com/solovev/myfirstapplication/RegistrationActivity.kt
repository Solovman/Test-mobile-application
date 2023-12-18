package com.solovev.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val linkOnPhone = findViewById<TextView>(R.id.on_phone_label)
        val linkOnEmail = findViewById<TextView>(R.id.on_email_label)
        val linkToLogin = findViewById<TextView>(R.id.to_login_page_label)

        val buttonRegistration = findViewById<Button>(R.id.registration_button)

        linkToLogin.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)

            startActivity(intent)
        }

        // Обработка клика по номеру
        linkOnPhone.setOnClickListener {
            val inputPhone = findViewById<EditText>(R.id.email_or_phone_input)

            linkOnPhone.setTextColor(resources.getColor(R.color.purple))
            linkOnEmail.setTextColor(resources.getColor(R.color.gray))

            inputPhone.hint = "Введите номер телефона"
            inputPhone.textSize = 15f
            inputPhone.inputType = InputType.TYPE_CLASS_PHONE
        }

        // Обработка клика по email
        linkOnEmail.setOnClickListener {
            val inputEmail = findViewById<EditText>(R.id.email_or_phone_input)

            linkOnEmail.setTextColor(resources.getColor(R.color.purple))
            linkOnPhone.setTextColor(resources.getColor(R.color.gray))

            inputEmail.hint = "Введите Email"
            inputEmail.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        }

        val fullText = linkToLogin.text.toString()

        val startIndex = fullText.indexOf("Войти")
        val spannableString = SpannableString(fullText)

        // Установка цвета для слова "войдите"
        val colorSpan = ForegroundColorSpan(resources.getColor(R.color.purple))
        spannableString.setSpan(colorSpan, startIndex, startIndex + "Войти".length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        // Установите измененный текст в TextView
        linkToLogin.text = spannableString

        // Проверка корректности пароля
        fun String.isValidPassword(): Boolean {
            return length >= 8
        }

        // Отображение сообщений Toast
        fun showToast(message: String) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        buttonRegistration.setOnClickListener {
            val inputPhoneOrEmail = findViewById<EditText>(R.id.email_or_phone_input)
            val inputPassword = findViewById<EditText>(R.id.password_input).text.toString()
            val inputRepeatPassword = findViewById<EditText>(R.id.password_repeat_input).text.toString()

            when {
                inputPhoneOrEmail.hint == "Введите номер телефона" -> {
                    if (!inputPhoneOrEmail.text.toString().contains('+')) {
                        showToast("Некорректный номер телефона")
                    }
                }
                inputPhoneOrEmail.hint == "Введите Email" -> {
                    if (!inputPhoneOrEmail.text.toString().contains('@')) {
                        showToast("Некорректный email")
                    }
                }
                else -> {
                    showToast("Некорректный ввод")
                }
            }

            when {
                !inputPassword.isValidPassword() -> {
                    showToast("Пароль должен содержать минимум 8 символов")
                }
                inputPassword != inputRepeatPassword -> {
                    showToast("Пароль и его повторение не совпадают")
                }
                else -> {
                    // Код для обработки корректного ввода
                }
            }
        }

    }
}
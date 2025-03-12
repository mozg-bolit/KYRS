package com.example.kyrs

import  android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kyrs.data.MainDB
import com.example.kyrs.data.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val editLogin = findViewById<EditText>(R.id.editLogin).text.toString().trim()
            val editPassword = findViewById<EditText>(R.id.editPassword).text.toString().trim()

            // Пример сохранения пользователя в базу данных
            val user = User(username = editLogin, password = editPassword)
            val db = MainDB.getDb(this)
            db.getDao().insertUser(user) // Предположим, что у вас есть метод insertUser в DAO
        }


    }
}
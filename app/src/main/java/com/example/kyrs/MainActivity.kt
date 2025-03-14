package com.example.kyrs

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kyrs.data.MainDB
import com.example.kyrs.data.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var db: MainDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        // Инициализация базы данных
        db = MainDB.getDb(this)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val editLogin = findViewById<EditText>(R.id.editLogin).text.toString().trim()
            val editPassword = findViewById<EditText>(R.id.editPassword).text.toString().trim()

            // Добавления пользователя в базу данных
            val user = User(username =  editLogin, password = editPassword)

            // Используем корутины для работы с базой данных
            CoroutineScope(Dispatchers.IO).launch {
                db.getUserDao().insertUser(user)
                runOnUiThread {
                    Toast.makeText(this@MainActivity, "Пользователь добавлен", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Закрываем базу данных при завершении Activity
        db.close()
    }
}
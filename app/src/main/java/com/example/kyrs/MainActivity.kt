package com.example.kyrs

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kyrs.data.MainDB
import com.example.kyrs.data.Models.User
import com.example.kyrs.retrofit.Api
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var db: MainDB//

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Инициализация Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api/bebra/") // Убедитесь, что URL корректен
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val Api = retrofit.create(Api::class.java)

        // Инициализация базы данных
        db = MainDB.getDb(this)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val editLogin = findViewById<EditText>(R.id.editLogin).text.toString().trim()
            val editPassword = findViewById<EditText>(R.id.editPassword).text.toString().trim()
            val user = User(username = editLogin, password = editPassword)

            // Используем корутины для работы с базой данных и запроса
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val employee = Api.getEmployeeById(1) // Запрос Employee по id
                    val response = Api.sendUser(user)    // Отправка и получение ответа

                        // Обновление UI в главном потоке
                        withContext(Dispatchers.Main) {
                            val intent = Intent(this@MainActivity, MessageActivity::class.java)
                            startActivity(intent)
                            Toast.makeText(this@MainActivity, "Пользователь добавлен", Toast.LENGTH_SHORT).show()
                        }
                        // Обработка ошибки сервера
                        val errorBody = response.errorBody()?.string()
                        println("Ошибка сервера: $errorBody")
                        withContext(Dispatchers.Main) {
                            val intent = Intent(this@MainActivity, MessageActivity::class.java)
                            startActivity(intent)
                            Toast.makeText(this@MainActivity, "Ошибка сервера: $errorBody", Toast.LENGTH_SHORT).show()
                        }
                } catch (e: Exception) {
                    // Обработка других ошибок (например, отсутствие интернета)
                    e.printStackTrace()
                    withContext(Dispatchers.Main) {
                        val intent = Intent(this@MainActivity, MessageActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this@MainActivity, "Ошибка: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
package com.example.kyrs

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
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
     private lateinit var db: MainDB
     private lateinit var token:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        //Retrofit
        /////////////////////////////////////////////////////////////////////////////
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api/bebra") //Затычка
            .addConverterFactory(GsonConverterFactory.create()).build()
        val Api = retrofit.create(Api::class.java)
        /////////////////////////////////////////////////////////////////////////////

        // Инициализация базы данных
        db = MainDB.getDb(this)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val editLogin = findViewById<EditText>(R.id.editLogin).text.toString().trim()
            val editPassword = findViewById<EditText>(R.id.editPassword).text.toString().trim()
            val user = User(username =  editLogin, password = editPassword, token = token)// Добавления пользователя в базу данных



            // Используем корутины для работы с базой данных и запроса
            CoroutineScope(Dispatchers.IO).launch {//Запуск второстепенного потока
                val employee = Api.getEmployeeById(1) //Запрос Employee по id
                val response = Api.sendUser(user)       //Отправка и получение ответа

                if(response.isSuccessful){
                    val token = response.body()?.token //Получение токена
                    if (token != null) {
                        db.getUserDao().insertUser(user)
                    }

                    runOnUiThread { //Запуск основного потока
                        val intent = Intent(this@MainActivity, Home::class.java)
                        startActivity(intent)

                        Toast.makeText(this@MainActivity, "Пользователь добавлен", Toast.LENGTH_SHORT)
                        .show()
                    }
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
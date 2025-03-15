package com.example.kyrs

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.kyrs.data.MainDB
import com.example.kyrs.data.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var db: MainDB
    private lateinit var url:String

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

    private fun sendJsonAuto(username:String, password:String){
        url = ""
        val queue = Volley.newRequestQueue(this)

        val Json = JSONObject().apply {
            put("username","${username}")
            put("password","${password}")
        }

        val jsonObjectRequest = JsonObjectRequest(Request.Method.POST, url, Json,
            //Respounse.Listener
            { response ->
                try {
                    val token = response.getString("token")
                    saveToken(token)//Сохраняю токен

                    Toast.makeText(this, "Токен получен: $token", Toast.LENGTH_SHORT).show()
                }catch (e: JSONException){
                    Toast.makeText(this, "Ошибка при обработке ответа", Toast.LENGTH_SHORT).show()
                }
            },
            //Respounse.ErrorListener
            {
                error ->
                Toast.makeText(this, "Ошибка: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        )
        queue.add(jsonObjectRequest)
    }

    private fun saveToken(token:String){
        //Используем SharedPreferences
        val sharedPreferences = getSharedPreferences("KYRS", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("token", token)
        editor.apply()
    }


    override fun onDestroy() {
        super.onDestroy()
        // Закрываем базу данных при завершении Activity
        db.close()
    }
}
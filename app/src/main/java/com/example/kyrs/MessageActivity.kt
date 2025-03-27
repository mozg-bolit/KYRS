package com.example.kyrs

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kyrs.data.Models.Message
import com.google.android.material.bottomnavigation.BottomNavigationView

class MessageActivity : AppCompatActivity() {


    private lateinit var appBarConfiguration: AppBarConfiguration

    //private val list_messages = mutableListOf<Message>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_message)

        // Установка Toolbar в качестве ActionBar
        setSupportActionBar(findViewById(R.id.toolbar)) // Добавьте этот элемент в ваш layout

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_rass,
                R.id.navigation_employee,
                R.id.navigation_message,
                R.id.navigation_settings,
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_employee -> {
                    navController.navigate(R.id.employeeFragment)
                    true
                }
                R.id.navigation_rass -> {
                    navController.navigate(R.id.rassFragment)
                    true
                }
                R.id.navigation_settings -> {
                    navController.navigate(R.id.settingFragment)
                    true
                }
                R.id.navigation_message -> {
                    navController.navigate(R.id.messageFragment)
                    true
                }
                else -> false
            }
        }






//        // Используем RecyclerView для setOnApplyWindowInsetsListener
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.messages)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//
//
//        // Настраиваем RecyclerView
//        val recyclerView: RecyclerView = findViewById(R.id.messages)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        val adapter = MessageAdapter(this, list_messages)
//        recyclerView.adapter = adapter


    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }




//        // Заполняем список сообщений
//        setMessages()
//    private fun setMessages() {
//        val messages = listOf(
//            Message(null, "Федор", "Иванов", "Петрович", "Привет!", 1672531200000L),
//            Message(null, "Мария", "Сидорова", "Ивановна", "Как дела?", 1672617600000L),
//            Message(null, "Алексей", "Петров", "Сергеевич", "Что нового?", 1672704000000L),
//            Message(null, "Федор", "Иванов", "Петрович", "Привет!", 1672531200000L),
//            Message(null, "Федор", "Иванов", "Петрович", "Привет!", 1672531200000L),
//            Message(null, "Федор", "Иванов", "Петрович", "Привет!", 1672531200000L),
//            Message(null, "Федор", "Иванов", "Петрович", "Привет!", 1672531200000L),
//            Message(null, "Федор", "Иванов", "Петрович", "Привет!", 1672531200000L),
//            Message(null, "Федор", "Иванов", "Петрович", "Привет!", 1672531200000L),
//            Message(null, "Алексей", "Петров", "Сергеевич", "Что нового?", 1672704000000L),
//            Message(null, "Ольга", "Кузнецова", "Александровна", "Все хорошо!", 1672790400000L)
//        )
//        list_messages.addAll(messages)
//    }


}


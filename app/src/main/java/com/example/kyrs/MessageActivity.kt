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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kyrs.data.Models.Message
import com.example.kyrs.databinding.ActivityMainBinding

class MessageActivity : AppCompatActivity() {

    private lateinit var conf: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    private val list_messages = mutableListOf<Message>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.ab.toolbar)
        navController = findNavController(R.id.fragmentContainerView)
        conf = AppBarConfiguration(
            setOf(R.id.item1, R.id.item2),
            binding.drawer
        )
        setupActionBarWithNavController(navController, conf)
        binding.navView.setupWithNavController(navController)


        // Используем RecyclerView для setOnApplyWindowInsetsListener
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.messages)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Заполняем список сообщений
        setMessages()

        // Настраиваем RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.messages)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MessageAdapter(this, list_messages)
        recyclerView.adapter = adapter


    }

    private fun setMessages() {
        val messages = listOf(
            Message(null, "Федор", "Иванов", "Петрович", "Привет!", 1672531200000L),
            Message(null, "Мария", "Сидорова", "Ивановна", "Как дела?", 1672617600000L),
            Message(null, "Алексей", "Петров", "Сергеевич", "Что нового?", 1672704000000L),
            Message(null, "Федор", "Иванов", "Петрович", "Привет!", 1672531200000L),
            Message(null, "Федор", "Иванов", "Петрович", "Привет!", 1672531200000L),
            Message(null, "Федор", "Иванов", "Петрович", "Привет!", 1672531200000L),
            Message(null, "Федор", "Иванов", "Петрович", "Привет!", 1672531200000L),
            Message(null, "Федор", "Иванов", "Петрович", "Привет!", 1672531200000L),
            Message(null, "Федор", "Иванов", "Петрович", "Привет!", 1672531200000L),
            Message(null, "Алексей", "Петров", "Сергеевич", "Что нового?", 1672704000000L),
            Message(null, "Ольга", "Кузнецова", "Александровна", "Все хорошо!", 1672790400000L)
        )
        list_messages.addAll(messages)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(conf) || super.onSupportNavigateUp()
    }
}
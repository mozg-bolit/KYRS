package com.example.kyrs

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kyrs.data.Models.Message
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MessageAdapter(private val context: Context, private val messages: List<Message>):RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    //В него суём элементы XML
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val nameTextView = view.findViewById<TextView>(R.id.nameTextView)
        val textTextView = view.findViewById<TextView>(R.id.textTextView)
        val dateTextView = view.findViewById<TextView>(R.id.dateTextView)
    }
   //возвращает объект ViewHolder, который будет хранить данные по одному объекту Message
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.message, parent, false)
       return ViewHolder(view)
   }

    private val dateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())

    //выполняет привязку объекта ViewHolder к объекту Message по определенной позиции
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = messages[position]
        val fullName = "${message.name} ${message.surname} ${message.patronymic}"
        holder.nameTextView.text = fullName
        holder.textTextView.text = message.text
        // Преобразование Long в строку с датой
        val dataString = dateFormat.format(Date(message.date))
        holder.dateTextView.text = dataString
    }

    //возвращает количество объектов в списке
    override fun getItemCount(): Int {
        return messages.size
    }
}
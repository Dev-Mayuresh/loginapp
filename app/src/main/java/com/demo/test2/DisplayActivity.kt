package com.demo.test2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val tvName: TextView = findViewById(R.id.tVName)
        val tvAge: TextView = findViewById(R.id.tVAge)
        val tvEmail: TextView = findViewById(R.id.tVEmail)
        val btnBack: Button = findViewById(R.id.btnBack)

        val name = intent.getStringExtra("NAME")
        val age = intent.getStringExtra("AGE")
        val email = intent.getStringExtra("EMAIL")

        tvName.text = "Name: $name"
        tvAge.text = "Age: $age"
        tvEmail.text = "Email: $email"

        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
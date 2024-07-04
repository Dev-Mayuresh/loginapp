package com.demo.test2


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editTextName: EditText
    private lateinit var editTextAge: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var buttonSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        editTextAge = findViewById(R.id.editTextAge)
        editTextEmail = findViewById(R.id.editTextEmail)
        buttonSubmit = findViewById(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            val name = editTextName.text.toString()
            val age = editTextAge.text.toString()
            val email = editTextEmail.text.toString()

            if (name.isNotEmpty() && age.isNotEmpty() && email.isNotEmpty()) {
                val intent = Intent(this, DisplayActivity::class.java).apply {
                    putExtra("NAME", name)
                    putExtra("AGE", age)
                    putExtra("EMAIL", email)
                }
                startActivity(intent)
            } else {
            }
        }
    }
}
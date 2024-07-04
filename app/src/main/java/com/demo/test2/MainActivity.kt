package com.demo.test2


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editTextName: EditText
    private lateinit var editTextAge: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var buttonSubmit: Button
    private lateinit var loadingBar: ProgressBar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        editTextAge = findViewById(R.id.editTextAge)
        editTextEmail = findViewById(R.id.editTextEmail)
        buttonSubmit = findViewById(R.id.buttonSubmit)
        loadingBar = findViewById(R.id.progressBar)


        buttonSubmit.setOnClickListener {
            loadingBar.visibility=View.VISIBLE
            val name = editTextName.text.toString()
            val age = editTextAge.text.toString()
            val email = editTextEmail.text.toString()

            if (name.isNotEmpty() && age.isNotEmpty() && email.isNotEmpty()) {
                // Show a Toast message indicating that data submission is in progress
                Toast.makeText(this, "Submitting data...", Toast.LENGTH_SHORT).show()


                // Use Handler to delay the start of DisplayActivity by 3 seconds (3000 milliseconds)
                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, DisplayActivity::class.java).apply {
                        putExtra("NAME", name)
                        putExtra("AGE", age)
                        putExtra("EMAIL", email)
                    }
                    loadingBar.visibility=View.GONE
                    startActivity(intent)
                }, 3000) // 3000 milliseconds delay
            } else {
                // Handle empty fields by showing a Toast message
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
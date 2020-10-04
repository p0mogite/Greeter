package com.example.greeter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var name = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            displayMessage()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("name", name)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val name = savedInstanceState.getString("name")
        displayMessage()
    }

    private fun isAlpha(name: String): Boolean {
        var chars = name.toCharArray()
        for (c in name) {
            if (c.isLetter()) {
                return true
            }
        }
        return false
    }

    private fun displayMessage() {
        val text: EditText = findViewById(R.id.name)
        name = text.text.toString()
        if (name.isEmpty()) {
            Toast.makeText(this, "Name field cannot be empty", Toast.LENGTH_SHORT).show()
        } else if (!isAlpha(name)){
            Toast.makeText(this, "Name should contain only letters", Toast.LENGTH_SHORT).show()
        } else {
            var output = "Hello, $name"
            val message: TextView = findViewById(R.id.message)
            message.text = output
        }
    }
}

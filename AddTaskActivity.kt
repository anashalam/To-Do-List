package com.example.to_dolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class AddTaskActivity : AppCompatActivity() {
    private val viewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_task)

        val titleInput = findViewById<EditText>(R.id.editTitle)
        val descInput = findViewById<EditText>(R.id.editDescription)
        val saveButton = findViewById<Button>(R.id.btnSave)

        saveButton.setOnClickListener {
            val title = titleInput.text.toString().trim()
            val desc = descInput.text.toString().trim()

            if (title.isNotEmpty()) {
                val task = Task(
                    title = title,
                    description = desc
                )
                viewModel.insert(task)
                Toast.makeText(this, "Task Added", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Please enter a title", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

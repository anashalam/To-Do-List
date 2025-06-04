package com.example.to_dolist

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class Task(
 @PrimaryKey(autoGenerate = true)
 val id: Int = 0,
 val title: String,
 val description: String,
 val timestamp: Long = System.currentTimeMillis(),
 val isDone: Boolean = false
)

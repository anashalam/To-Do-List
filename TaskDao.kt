package com.example.to_dolist


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {

    @Insert
    suspend fun insert(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Update
    suspend fun update(task: Task)

    @Query("SELECT * FROM task ORDER BY timestamp DESC")
    fun getAllTasks(): LiveData<List<Task>>

}

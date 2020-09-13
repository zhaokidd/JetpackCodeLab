package com.example.googlecodelabjetpackarchitechture.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.googlecodelabjetpackarchitechture.entity.Word

@Dao
interface WordDao {
    @Query("SELECT * from word_table ORDER BY id ASC")
    fun getAlphabetizedWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}
package com.example.googlecodelabjetpackarchitechture.dao

import androidx.lifecycle.LiveData
import com.example.googlecodelabjetpackarchitechture.entity.Word

class WordRepository(private val wordDao: WordDao) {
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}
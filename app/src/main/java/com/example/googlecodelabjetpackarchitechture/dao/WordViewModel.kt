package com.example.googlecodelabjetpackarchitechture.dao

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.googlecodelabjetpackarchitechture.entity.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {
    private val repository:WordRepository
    val allWords: LiveData<List<Word>>

    init{
        val wordsDao = WordRoomDatabase.getDatabase(application, viewModelScope).wordDao() //获取dao对象

        repository = WordRepository(wordsDao) //初始化repository
        allWords = repository.allWords //从repository中获取对象.
    }

    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }
}
package com.example.notebookroom.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notebookroom.REPOSITORY
import com.example.notebookroom.db.NoteDatabase
import com.example.notebookroom.db.repository.NoteRealization
import com.example.notebookroom.model.NoteModel

class StartViewModel(application: Application) : AndroidViewModel(application) {

    private val context = application

    fun initDatabase() {
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()

        REPOSITORY = NoteRealization(daoNote)


    }

    fun getAllNotes(): LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }

}
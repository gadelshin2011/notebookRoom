package com.example.notebookroom.db.repository

import androidx.lifecycle.LiveData
import com.example.notebookroom.model.NoteModel

interface NoteRepository {
    //список функции

    val allNotes: LiveData<List<NoteModel>>

    suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit)
    suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit)


}
package com.example.notebookroom.screens.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notebookroom.REPOSITORY
import com.example.notebookroom.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel: ViewModel() {

    fun insert(noteModel: NoteModel, onSuccess:() ->Unit){
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.insertNote(noteModel){
                onSuccess()
            }
        }
    }
}
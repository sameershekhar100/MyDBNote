package com.example.mynote;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Database;

import java.util.List;

class Repository {
    NoteDao noteDao;
    LiveData<List<note>> allNotes;
    Repository(Application application){
        Note_Database db = Note_Database.getDatabase(application);
        noteDao = db.getDao();
       allNotes=noteDao.getAllNotes();

    }
    void insert(note Note){
        Note_Database.databaseWriteExecutor.execute(() -> {
            noteDao.insert(Note);
        });    }

    void delete(note Note){
        Note_Database.databaseWriteExecutor.execute(() -> {
        noteDao.delete(Note);
        });  }
}

package com.example.mynote;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
     private Repository mRepository;
    LiveData<List<note>> mallNotes;
    Note_Database note_database;
    NoteDao dao;

    public NoteViewModel(@NonNull Application application) {
        super(application);

        mRepository = new Repository(application);

        mallNotes=mRepository.allNotes;
    }

    public LiveData<List<note>> getMallNotes() {
        return mallNotes;
    }
    public void insert(note Note){
        mRepository.insert(Note);
    }

    public void delete(note Note){
        mRepository.delete(Note);
    }
}

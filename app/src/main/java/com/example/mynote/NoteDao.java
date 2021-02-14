package com.example.mynote;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     void  insert(note Note);
    @Delete
    void delete(note Note);

    @Query("SELECT * FROM notes_table ORDER BY text ASC")
   LiveData<List<note>> getAllNotes();
}

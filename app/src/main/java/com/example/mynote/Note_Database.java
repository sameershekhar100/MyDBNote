package com.example.mynote;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {note.class}, version = 1, exportSchema = false)
public abstract class Note_Database extends RoomDatabase {
    public abstract NoteDao getDao();

    private static volatile Note_Database INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static Note_Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Note_Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Note_Database.class, "note_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

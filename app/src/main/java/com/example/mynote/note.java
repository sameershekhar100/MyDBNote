 package com.example.mynote;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes_table")
public class note {

//    private  int id;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "text")
    public   String Text;

    public note(@NonNull String Text){

        this.Text = Text;

    }

//    public void setId(int id) {
//        this.id = id;
//    }

    @NonNull
    public String getText() {
        return Text;
    }
}

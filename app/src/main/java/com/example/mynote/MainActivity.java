package com.example.mynote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynote.*;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements INotesRVAdapter {
private   NoteViewModel viewModel;
RecyclerView recyclerView;
    EditText e1;
    Button add;
    RecyclerView.LayoutManager layoutManager;
    NotesRVAdapter madapter= new  NotesRVAdapter(this,this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editTextTextPersonName);
        add=findViewById(R.id.addButton);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(madapter);
        viewModel=new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.
                getInstance(getApplication())).get(NoteViewModel.class);
        viewModel.getMallNotes().observe(this, new Observer<List<note>>() {
            @Override
            public void onChanged(List<note> notes) {
                madapter.update(notes);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData(v);
            }


        });
    }
    public void addData(View v){
        String s1=e1.getText().toString();
        if(!s1.isEmpty()){
            note n=new note(s1);
            Log.d("tag","hi ");

            viewModel.insert(n);

            Toast.makeText(this, "note inserted", Toast.LENGTH_SHORT).show();
        }


    }


    @Override
    public void onItemClicked(note Note) {
        viewModel.delete(Note);
        Toast.makeText(this, "working", Toast.LENGTH_SHORT).show();
    }
}
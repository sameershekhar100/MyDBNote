package com.example.mynote;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesRVAdapter extends RecyclerView.Adapter<NoteViewHolder> {
public ArrayList<note> allnotes=new ArrayList<>();
    public INotesRVAdapter listener;
    Context mContext;
    public NotesRVAdapter(Context context,INotesRVAdapter listener){
        this.mContext=context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note, parent, false);
        NoteViewHolder v=new NoteViewHolder(view);

        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        String s= allnotes.get(position).getText();
        holder.noteItemView.setText(s);
        holder.delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("abcd", "we have "+allnotes.get(position));
                listener.onItemClicked(allnotes.get(position));
            }
        });



    }

    @Override
    public int getItemCount() {
        return allnotes.size();
    }

    public void update(List<note> arr){
        allnotes.clear();
        allnotes.addAll(arr);

        notifyDataSetChanged();
    }
}
class NoteViewHolder extends RecyclerView.ViewHolder{
      TextView noteItemView;
     ImageView delButton;
    public NoteViewHolder (@NonNull View itemView) {
        super(itemView);
        delButton=itemView.findViewById(R.id.button);
        noteItemView=itemView.findViewById(R.id.text);
    }

}

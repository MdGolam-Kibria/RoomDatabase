package com.example.roomdatabase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.R;
import com.example.roomdatabase.entity.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyHolder> {
    private List<Note> noteList = new ArrayList<>();
    Context context;

    public NoteAdapter(Context context) {
        this.context = context;
    }

    public void setNotes(List<Note> notes){
        this.noteList = notes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.note_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Note currentNote = noteList.get(position);
        holder.title.setText(currentNote.getTitle());
        holder.description.setText(currentNote.getDescription());
        holder.priroty.setText(String.valueOf(currentNote.getPriority()));
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView title, description, priroty;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTv);
            description = itemView.findViewById(R.id.descriptionTv);
            priroty = itemView.findViewById(R.id.priortyTv);
        }
    }
}

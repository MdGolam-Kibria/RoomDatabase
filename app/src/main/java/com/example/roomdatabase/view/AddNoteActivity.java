package com.example.roomdatabase.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomdatabase.R;
import com.example.roomdatabase.entity.Note;
import com.example.roomdatabase.viewModel.NoteViewModel;

public class AddNoteActivity extends AppCompatActivity {
    public EditText title, description, priority;
    private Button saveBtn,delete;
    NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        init();
        noteViewModel = ViewModelProviders.of(AddNoteActivity.this).get(NoteViewModel.class);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String utitle = title.getText().toString();
                String udescription = description.getText().toString();
                String upriority = priority.getText().toString();
                Note note = new Note(utitle, udescription, Integer.parseInt(upriority));
                noteViewModel.insert(note);
                startActivity(new Intent(AddNoteActivity.this, MainActivity.class));
                finish();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noteViewModel.deleteAllNotes();
                startActivity(new Intent(AddNoteActivity.this, MainActivity.class));
                finish();
            }
        });


    }

    private void init() {
        title = findViewById(R.id.titleEt);
        description = findViewById(R.id.descriptionEt);
        priority = findViewById(R.id.priorityEt);
        saveBtn = findViewById(R.id.addBtn);
        delete = findViewById(R.id.delete);
    }
}
package com.example.roomdatabase.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.roomdatabase.R;
import com.example.roomdatabase.adapter.NoteAdapter;
import com.example.roomdatabase.entity.Note;
import com.example.roomdatabase.viewModel.NoteViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;
    private RecyclerView recyclerView;
    FloatingActionButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddNoteActivity.class));
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);
        NoteAdapter adapter = new NoteAdapter(MainActivity.this);
        recyclerView.setAdapter(adapter);


        noteViewModel = ViewModelProviders.of(MainActivity.this).get(NoteViewModel.class);//init the view model
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                Toast.makeText(MainActivity.this, "on changed", Toast.LENGTH_LONG).show();
                adapter.setNotes(notes);
            }
        });
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        button = findViewById(R.id.next);

    }
}
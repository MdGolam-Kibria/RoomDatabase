package com.example.roomdatabase.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomdatabase.dao.NoteDao;
import com.example.roomdatabase.entity.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    public static NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),//context
                    NoteDatabase.class,//database class name
                    "note_database"//database name
            )
                    .addCallback(roomCallBack)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };


    public static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private NoteDao noteDao;

        public PopulateDbAsyncTask(NoteDatabase noteDatabase) {
            this.noteDao = noteDatabase.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
//            noteDao.insertData(new Note("kibria", "hi mySelf Kibria", 1));
//            noteDao.insertData(new Note("helal", "hi mySelf helal", 2));
//            noteDao.insertData(new Note("sohag", "hi mySelf sohag", 3));
            return null;
        }
    }
}

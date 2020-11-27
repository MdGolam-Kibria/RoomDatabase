package com.example.roomdatabase.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "attribute")
public class Attr {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int noteId;
    private String attributeId;
    private String attributeVal;
}

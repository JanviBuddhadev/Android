package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.HashSet;

public class NoteEditorActivity extends AppCompatActivity {
    EditText ed;
    int notId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);
        ed=findViewById(R.id.editText);
        Intent intent=getIntent();
        notId=intent.getIntExtra("noteId",-1);
        if(notId!=-1)
        {
            ed.setText(MainActivity.notes.get(notId));
        }
        else
        {
            MainActivity.notes.add(" ");
            notId=MainActivity.notes.size()-1;
        }
        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.notes.set(notId,String.valueOf(s));
                MainActivity.adpt.notifyDataSetChanged();

                SharedPreferences sp=getApplicationContext().getSharedPreferences("com.example.notesapp", Context.MODE_PRIVATE);
                HashSet<String> sets=new HashSet<>(MainActivity.notes);
                sp.edit().putString("notes", String.valueOf(sets)).apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}

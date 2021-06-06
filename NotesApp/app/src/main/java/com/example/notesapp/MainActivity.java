package com.example.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    static ArrayList<String> notes=new ArrayList<>();
    static ArrayAdapter adpt;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=getApplicationContext().getSharedPreferences("com.example.notesapp", Context.MODE_PRIVATE);
        lv=findViewById(R.id.listview);
        //HashSet<String> sets=new HashSet<>(MainActivity.notes);
        /*HashSet<String> set= (HashSet<String>) sp.getStringSet("notes",null);
        if(set==null)
        {
            notes.add("Example Note");
        }
        else
        {
            notes=new ArrayList(set);
        }*/
        notes.add("Example Note");
         adpt=new ArrayAdapter(this,android.R.layout.simple_list_item_1,notes);
        lv.setAdapter(adpt);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getApplicationContext(),NoteEditorActivity.class);
                i.putExtra("noteId",position);
                startActivity(i);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int itemToDelete=position;
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Are you sure?...")
                        .setMessage("Do you want to delete this Note?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                notes.remove(itemToDelete);
                                adpt.notifyDataSetChanged();

                                HashSet<String> sets=new HashSet<>(MainActivity.notes);
                                sp.edit().putString("notes", String.valueOf(sets)).apply();
                            }
                        }).setNegativeButton("No",null).show();



                return true;
            }
        });
    }
    //MENU

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuinflater=getMenuInflater();
        menuinflater.inflate(R.menu.add_note_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.add_note) {
            Intent intent = new Intent(getApplicationContext(), NoteEditorActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
}

package com.example.databsedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper db=new DBHelper(this);
        name=findViewById(R.id.editText);
        age=findViewById(R.id.editText2);

    }
    public void insert(View view)
    {
        DBHelper db=new DBHelper(this);
        boolean isinsert=db.insertdata(name.getText().toString(),Integer.parseInt(age.getText().toString()));
        if(isinsert==true){
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Error..Please Try Again", Toast.LENGTH_LONG).show();
        }
    }
    public void show(View view)
    {
        DBHelper db=new DBHelper(this);
        Cursor c=db.getAlldata();
        if(c.getCount()==0)
        {
            Toast.makeText(this, "No Record Found", Toast.LENGTH_SHORT).show();
        }
        while(c.moveToNext()){
            Toast.makeText(this, c.getString(0), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, c.getString(1), Toast.LENGTH_SHORT).show();
        }
    }
}

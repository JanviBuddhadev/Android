package com.example.brain_trainer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class Quizdbhelper extends SQLiteOpenHelper {
    public Quizdbhelper(@Nullable Context context) {
        super(context, "quiz", null, 1);
    }
    private SQLiteDatabase db;
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;
        db.execSQL("Create table easymath (ID INTEGER PRIMARY KEY AUTOINCREMENT,QUE TEXT,OPTION1 TEXT,OPTION2 TEXT,OPTION3 TEXT,CORRECT INTEGER)");
        fileset();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    private void fileset()
    {
        Questions que1=new Questions("10/2+?=10","9","5","8",2);
        addque(que1);
        Questions que2=new Questions("(9+5)-?=5 ","9","7","5",1);
        addque(que2);
        Questions que3=new Questions("7-5+3=?","7","9","5",3);
        addque(que3);
        Questions que4=new Questions("(?+6)-7=5","15","10","6",3);
        addque(que4);
        Questions que5=new Questions("(23-5)-?=9","9","1","5",1);
        addque(que5);
        Questions que6=new Questions("(7+9)-8=?","8","17","3",1);
        addque(que6);
        Questions que7=new Questions("10-5+1=?","8","6","4",2);
        addque(que7);
        Questions que8=new Questions("(?+9)-7=8","16","6","12",2);
        addque(que8);
        Questions que9=new Questions("13-8+?=9","4","16","12",1);
        addque(que9);
        Questions que10=new Questions("(5+2)*3","18","21","10",2);
        addque(que10);
        Questions que11=new Questions("(21-7)/?=7","10","4","2",3);
        addque(que11);
        Questions que12=new Questions("(8+10)/?=9","2","13","3",1);
        addque(que12);
        Questions que13=new Questions("16/2*?=8","17","1","16",2);
        addque(que13);
        Questions que14=new Questions("?+4+3=8","17","10","1",3);
        addque(que14);
        Questions que15=new Questions("(6+9)-?=6","9","8","3",1);
        addque(que15);
        Questions que16=new Questions("2*6-?=8","1","4","6",2);
        addque(que16);
        Questions que17=new Questions("(22-?)-8=5","19","10","9",3);
        addque(que17);
        Questions que18=new Questions("?-6+1=6","11","15","8",1);
        addque(que18);
        Questions que19=new Questions("8/?+4=5","1","8","6",2);
        addque(que19);
        Questions que20=new Questions("48/2(9+3)=?","9","10","2",3);
        addque(que20);
        Questions que21=new Questions("5+8/2-7=?","2","4","8",1);
        addque(que21);
        Questions que22=new Questions("8+?=24","14","16","20",2);
        addque(que22);
        Questions que23=new Questions("?+3+2=17","16","10","12",3);
        addque(que23);
        Questions que24=new Questions("(13-7)*5=?","30","25","35",1);
        addque(que24);
        Questions que25=new Questions("(20-?)+6=15","14","11","20",2);
        addque(que25);
        Questions que26=new Questions("(?-5)*3=9","17","10","8",3);
        addque(que26);
        Questions que27=new Questions("select the correct pair of symbol for this equation: 30 ? 2 ? 3=18","/,+","+,/","-,/",1);
        addque(que27);
        Questions que28=new Questions("select the correct pair of symbol for this equation: 30 ? 2 ? 3=24","-,/","-,*","-,+",2);
        addque(que28);
        Questions que29=new Questions("Select the correct pair of symbol for this equation: 10 ? 2 ? 3 = 16","*,+","+,/","+,*",3);
        addque(que29);
        Questions que30=new Questions("5*?+3=23","4","6","5",1);
        addque(que30);
        Questions que31=new Questions("4*?+3=11","4","2","1",2);
        addque(que31);
        Questions que32=new Questions("4+4*2+?=19","8","9","7",3);
        addque(que32);
        Questions que33=new Questions("4-?/8=1","24","8","20",1);
        addque(que33);
        Questions que34=new Questions("20-?*3=5","10","5","4",2);
        addque(que34);
        Questions que35=new Questions("17-3*?=11","10","4","2" ,3);
        addque(que35);
        Questions que36=new Questions("17+4-4*3=?","9","6","3",1);
        addque(que36);
        Questions que37=new Questions("3*5*4=?","30","60","20",2);
        addque(que37);
        Questions que38=new Questions("40-5*3=?","15","35","25" ,3);
        addque(que38);
        Questions que39=new Questions("16/5+3*1=?","2","8","4",1);
        addque(que39);
        Questions que40=new Questions("5*4/2+6=?","12","16","10",2);
        addque(que40);
        Questions que41=new Questions("5*4-14*2","10","8","-8" ,3);
        addque(que41);
        Questions que42=new Questions("4*4-6/3+5=?","9","19","8",1);
        addque(que42);
        Questions que43=new Questions("18/2*4-1*6=?","26","30","24",2);
        addque(que43);
        Questions que44=new Questions("5*4-3+1-2+1=?","17","23","13" ,3);
        addque(que44);
    }
    private void addque(Questions question)
    {
        ContentValues cv=new ContentValues();
        cv.put("QUE",question.getQue());
        cv.put("OPTION1",question.getOption1());
        cv.put("OPTION2",question.getOption2());
        cv.put("OPTION3",question.getOption3());
        cv.put("CORRECT",question.getCorrect());
        db.insert("easymath",null,cv);
    }
    public List<Questions> getallque()
    {
        List<Questions> quelist=new ArrayList<>();
        db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from easymath",null);
        if(c.moveToFirst()){
            do{
                Questions question=new Questions();
                question.setQue(c.getString(c.getColumnIndex("QUE")));
                question.setOption1(c.getString(c.getColumnIndex("OPTION1")));
                question.setOption2(c.getString(c.getColumnIndex("OPTION2")));
                question.setOption3(c.getString(c.getColumnIndex("OPTION3")));
                question.setCorrect(c.getInt(c.getColumnIndex("CORRECT")));
                quelist.add(question);
            }while(c.moveToNext());

        }
        c.close();
        return quelist;
    }
}

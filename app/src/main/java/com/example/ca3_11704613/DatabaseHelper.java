package com.example.ca3_11704613;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="library2.db";
    public static final String TABLE_NAME="books";
    public String availStatus="Available";


    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery="create TABLE "+TABLE_NAME+" (ID Integer Primary Key AUTOINCREMENT," +
                "Book_Name text," +
                "Availibility text)";
        String table2query="create Table student (ID Integer Primary key AutoIncrement ,RegNo text ,Book text,status text)";
        db.execSQL(createQuery);
        db.execSQL(table2query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if exists "+TABLE_NAME);
        db.execSQL("Drop Table if exists student");
        onCreate(db);

    }

    public void insertDataIntoBooks(String bookName){
        SQLiteDatabase db;
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Book_Name",bookName);
        values.put("Availibility",availStatus);
        db.insert(TABLE_NAME,null,values);
    }
    public void insertDataIntoStudent(String regNumber,String bookName,String status){
        SQLiteDatabase db;
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Regno",regNumber);
        values.put("Book",bookName);
        values.put("status",status);
        db.insert("student",null,values);
    }

    public Cursor getAllDataFromBooksTable(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+TABLE_NAME+" where Availibility='Available'",null);
        return  cursor;
    }
    public Cursor getAllDataFromStudent(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from student where RegNo= "+MainActivity.getRegistration()+" AND status='Unavailable' " ,null);
        return  cursor;
    }

    public  boolean updateBooksAvail(String Id,String status){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Availibility",status);
        db.update(TABLE_NAME,values,"ID= ?",new String[]{Id});
        return true;
    }
}


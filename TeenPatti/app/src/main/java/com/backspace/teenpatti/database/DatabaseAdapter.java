package com.backspace.teenpatti.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

/**
 * Created by Backspace on 10/8/2016.
 */
public class DatabaseAdapter {
    public DatabaseHelper DBHelper;

    public DatabaseAdapter(Context context){
        DBHelper=new DatabaseHelper(context);
    }

    public long addUser(String userValue,String passValue){
        SQLiteDatabase db=DBHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(DatabaseHelper.PLAYER_NAME,userValue);
        values.put(DatabaseHelper.SCORE,passValue);
        long id=db.insert(DatabaseHelper.TABLE_NAME,null,values);
        return id;
    }

    public String getAllData(){
        StringBuffer buffer=new StringBuffer();
        try{
            SQLiteDatabase db=DBHelper.getWritableDatabase();
            String[]  columns={DatabaseHelper.UID, DatabaseHelper.PLAYER_NAME, DatabaseHelper.SCORE};
            Cursor cursor=db.query(DatabaseHelper.TABLE_NAME,columns,null,null,null,null,null );
            while (cursor.moveToNext()){
                int id=cursor.getInt(0);
                String username=" "+cursor.getString( 1 );
                String password=" "+cursor.getString( 2 )+"\n";
                buffer.append( id+username+password );
            }
        }catch (Exception e){

        }
        return buffer.toString();
    }
    public boolean isAccountExist(String nameValue,String passValue){
        boolean is=false;
        SQLiteDatabase db=DBHelper.getWritableDatabase();
        String[] columns={DatabaseHelper.UID};
        String[] selectionArgs={nameValue,passValue};
        Cursor cursor=db.query(DatabaseHelper.TABLE_NAME,columns, DatabaseHelper.PLAYER_NAME +" =? AND "+ DatabaseHelper.SCORE +" =?",selectionArgs,null,null,null );
        while (cursor.moveToNext()){
            is=true;
        }
        return is;
    }
    public int deleteThisAccount(String username){
        boolean is=false;
        SQLiteDatabase db=DBHelper.getWritableDatabase();
        String[] whereArgs={username};
        int count=db.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.PLAYER_NAME +" =?",whereArgs);
        return count;
    }
    public int updateThisAccount(String oldPassword,String newPassword){
        SQLiteDatabase db=DBHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(DatabaseHelper.SCORE, newPassword );
        String[] whereArgs={oldPassword};
        int count=db.update(DatabaseHelper.TABLE_NAME,values, DatabaseHelper.SCORE +" =?",whereArgs);
        return count;

    }

}

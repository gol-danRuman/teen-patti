package com.backspace.teenpatti.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Backspace on 11/21/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    //private static final values for database name,columns and query
    private static final String DATABASE_NAME="teenPatti_db";
    private static final int DATABASE_VERSION=1;

    public static final String TABLE_NAME="chips_table";

    public static final String UID="_id";
    public static final String PLAYER_NAME="player_name";
    public static final String SCORE="chips";

    private static final String DROP_TABLE="DROP TABLE IF EXISTS"+TABLE_NAME;
    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ( "+UID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+PLAYER_NAME+" VARCHAR(50) NOT NULL," +
            ""+SCORE+" INTEGER DEFAULT 250);";

    private Context context;
    public DatabaseHelper(Context context) { //constructor of inner class
        super(context, DATABASE_NAME,null,DATABASE_VERSION); //constructor of super class called
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //onCreate was called if table was not created
        try{
            db.execSQL(CREATE_TABLE); //create table
        }catch (Exception e){
            Toast.makeText( context,e+" ",Toast.LENGTH_LONG ).show(); //error on creating table for the first time
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //onUpgrade() was called . called when db_version increased
        try{
            db.execSQL(DROP_TABLE); //first delete table
            onCreate(db); //and then create that table with upgraded version
        }catch (Exception ex){
            //ERROR ON UPGRADE
        }
    }
}

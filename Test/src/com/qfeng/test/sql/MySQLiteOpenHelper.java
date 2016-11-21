package com.qfeng.test.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper{

	private static final String DB_NAME = "c.db";
	private static final int DB_VERSION = 1;
	private static final String SQL_CREATE_TABLE = "create table Boy(_id integer primary key autoincrement ,name varchar(64) )";

	public MySQLiteOpenHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}

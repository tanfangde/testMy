package com.qfeng.test.adapter;

import com.qfeng.test.sql.MySQLiteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
	private MySQLiteOpenHelper openHelper;

	public DBManager(Context context) {
		openHelper = new MySQLiteOpenHelper(context);
	}
	public long insert(ContentValues values) {
		long ret = -1;

		// 1. 需要获取到数据库对象 SQLiteDatabase
		SQLiteDatabase db = openHelper.getWritableDatabase();
		
		
		//开启一个事务
		
		try {
			ret = db.insert("Boy", null, values);
			//结束一个事务。 事务里面的所有操作，要么全部执行，要么全不执行。
			
		} finally {
			// 这句话，不管insert的过程中发生了什么，都会执行。
			db.close();
		}
		return ret;
	}

	
	public Cursor query(String selection,String[] selectionArgs){
		Cursor ret = null;
		
		SQLiteDatabase db = openHelper.getWritableDatabase();
		ret = db.query("Boy", null, selection, selectionArgs, null, null, null);
		
		return ret;
	}
}


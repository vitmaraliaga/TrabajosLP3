package com.example.loginfacebook;

import android.R.string;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper{
	

	private String sqlCreate= "create table user (id integer,nombre text, user text, password text, estado integer)";
	private String sqlInsert1= "insert into user(id, nombre, user, password, estado ) values (1,'vitmar', 'vit', '123456', 0)";
	private String sqlInsert2= "insert into user(id, nombre, user, password, estado ) values (2,'andres', 'and', '123', 0)";
	
	public SQLiteHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sqlCreate);
		db.execSQL(sqlInsert1);
		db.execSQL(sqlInsert2);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		// TODO Auto-generated method stub
		
	}

}

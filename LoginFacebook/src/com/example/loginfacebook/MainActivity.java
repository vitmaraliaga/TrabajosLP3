package com.example.loginfacebook;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		SQLiteHelper SQLiteHelper = new SQLiteHelper(
				getApplicationContext(), "dbUsuario", null, 1);
		SQLiteDatabase db= SQLiteHelper.getReadableDatabase();
		
		Cursor cursor = db.rawQuery("select * from user where estado=1 ", null);
		if (cursor.moveToNext()){//moveToNext te devuelve un boleano de verdadero o false
			Intent i = new Intent(getApplicationContext(), HomeActivity.class);
			startActivity(i);
			
		}
		db.close();
		
		Button btnIngresaar= (Button) findViewById(R.id.buttonIngresar);
		
		btnIngresaar.setOnClickListener(new OnClickListener() {// ctrl ship O para complementar
			SQLiteHelper SQLiteHelper = new SQLiteHelper(
					getApplicationContext(), "dbUsuario", null, 1);
			SQLiteDatabase db= SQLiteHelper.getWritableDatabase();
			
			
			TextView txtUser= (TextView) findViewById(R.id.editTextUser);
			TextView txtPass= (TextView) findViewById(R.id.editTextPassword);
			
			@Override
			public void onClick(View v) {
				
				Cursor cursor= db.rawQuery("select id from user where user='"+txtUser.getText()+"' and password='"+txtPass.getText()+"'",  null);	
				if (cursor.moveToNext()){
					
					
					ContentValues values= new ContentValues();
					values.put("estado", 1);
					db.update("user", values, "id="+cursor.getInt(0), null);
					
					//execSQL("update user set estado = 1 where user='"+txtUser.getText()+"' and password='"+txtPass.getText()+"'", null);
					
					Intent i = new Intent(getApplicationContext(), HomeActivity.class);
					startActivity(i);	
					
				}else{
					Toast.makeText(getApplicationContext()
						, "Usuario no valido"
							, Toast.LENGTH_SHORT).show();
					
				}
				// TODO Auto-generated method stub
				
			}
		});
			
		
	}
}

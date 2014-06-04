package com.example.loginfacebook;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
		
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.cerrar_sesion:
			
			SQLiteHelper SQLiteHelper= new SQLiteHelper(
					getApplicationContext(), "dbUsuario", null, 1);
			SQLiteDatabase db=SQLiteHelper.getWritableDatabase();
			db.execSQL("update user set estado = 0");
			Intent i= new Intent(getApplicationContext(), MainActivity.class);
			startActivity(i);
			break;

		default:
			break;
		}
		
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}
}

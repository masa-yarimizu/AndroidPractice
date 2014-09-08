package com.example.yarimizuverse.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.yarimizuverse.R;
import com.example.yarimizuverse.pojo.Note;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class TestActivity extends Activity {
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.sqlsample);
			
			MyOpenHelper helper = new MyOpenHelper(this);
			final SQLiteDatabase db = helper.getWritableDatabase();
			
			//EditText‚ÌŽæ“¾
			final EditText nameText = (EditText) findViewById(R.id.editName);
			final EditText ageText = (EditText) findViewById(R.id.editAge);
			
			Button entryButton = (Button) findViewById(R.id.insert);
			entryButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String name = nameText.getText().toString();
					String age = ageText.getText().toString();
					
					ContentValues insertValues = new ContentValues();
					insertValues.put("name", name);
					insertValues.put("age", age);
					long id = db.insert("person", name, insertValues);
				}
			});
			
			Button updateButton = (Button) findViewById(R.id.update);
			updateButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String name = nameText.getText().toString();
					String age = ageText.getText().toString();
					
					if (name.equals("")) {
						Toast.makeText(TestActivity.this, "–¼‘O‚ð“ü—Í‚µ‚Ä‚­‚¾‚³‚¢", Toast.LENGTH_SHORT).show();
					} else {
						ContentValues updateValues = new ContentValues();
						updateValues.put("age", age);
						db.update("person", updateValues, "name=?", new String[] {name});
					}
				}
			});
			
			Button deleteButton = (Button) findViewById(R.id.delete);
			deleteButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String name = nameText.getText().toString();
					String age = ageText.getText().toString();
					
					if  (name.equals("")) {
						Toast.makeText(TestActivity.this, "–¼‘O‚ð“ü—Í‚µ‚Ä‚­‚¾‚³‚¢", Toast.LENGTH_SHORT).show();
					} else {
						db.delete("person", "name=?", new String[] { name });
					}
				}
			});
			
			Button detaBaseButton = (Button) findViewById(R.id.dataBase);
			detaBaseButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent dbIntent = new Intent(TestActivity.this, ShowDataBase.class);
					startActivity(dbIntent);
				}
			});
			
		}
}

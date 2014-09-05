package com.example.fragmenttest;

import com.example.fragmenttest.R;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends FragmentActivity {
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		//スーパークラスのonCreateを呼び出す
		super.onCreate(savedInstanceState);
		
		//
		setContentView(R.layout.activity_main);
	}
}
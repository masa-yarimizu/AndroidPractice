package com.example.yarimizuverse.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.yarimizuverse.R;
import com.example.yarimizuverse.pojo.ListRowName;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;


public class MainActivity extends ActionBarActivity {
	
	static List<ListRowName> lrn = new ArrayList<ListRowName>();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lrn.add( new ListRowName("sampleYarimizu"));
        lrn.add( new ListRowName("sampleSQLite"));
        lrn.add( new ListRowName("bbb"));
        
        Log.d("****************", lrn.toString());
        
        ArrayAdapter<ListRowName> la = new ArrayAdapter<ListRowName>(this, android.R.layout.simple_dropdown_item_1line, lrn);
        
        ListView lv = (ListView)findViewById(R.id.listview);
        lv.setAdapter(la);
        
        lv.setOnItemClickListener( new AdapterView.OnItemClickListener() {
        	
        	@Override
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        		
        		ListView listView = (ListView)parent;
        		
        		//Log.d("TAG", "position:" + String.valueOf(position));
        		//Toast.makeText(getApplicationContext(), lrn.get(position).toString(), Toast.LENGTH_SHORT).show();
        		
        		if (position == 0) {
        			Intent intent = new Intent(MainActivity.this, SampleYarimizuActivity.class);
        			startActivity(intent);
        		}else if (position == 1){
        			Intent intent = new Intent(MainActivity.this, SQLiteSampleActivity.class);
        			startActivity(intent);
        		}
        		
        		
        		
        	}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	if (keyCode == KeyEvent.KEYCODE_BACK) {
    		return false;
    	}
    	return false;
    }
}

package com.example.singletouchsample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;


public class SingleTouchSampleActivity extends ActionBarActivity implements OnSeekBarChangeListener{
	
	TextView textViewAction;
	TextView textViewPoint;
	private SeekBar seekBar;
	private TextView barText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textViewAction = (TextView)findViewById(R.id.textViewAction);
        textViewPoint = (TextView)findViewById(R.id.textViewPoint);
        seekBar = (SeekBar)findViewById(R.id.seekBar1);
        barText = (TextView)findViewById(R.id.barText1);
        
        seekBar.setOnSeekBarChangeListener(this);
        
    }
    
    public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser) {
    	if (fromUser) {
    		barText.setText(Integer.toString(progress));
    	}
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	
    	int x = (int) event.getX();
    	int y = (int) event.getY();
    	
    	textViewPoint.setText("(" + x + "," + y + ")" );
    	
    	switch(event.getAction()) {
    	
    		case MotionEvent.ACTION_DOWN:
    			textViewAction.setText("ACTION_DOWN");
    			break;
    		
    		case MotionEvent.ACTION_UP:
    			textViewAction.setText("ACTION_UP");
    			break;
    			
    		case MotionEvent.ACTION_MOVE:
    			textViewAction.setText("ACTION_MOVE");
    			break;
    			
    		case MotionEvent.ACTION_CANCEL:
    			textViewAction.setText("ACTION_CANCEL");
    			break;
    			
    	} 
    	
    	return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.single_touch_sample, menu);
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
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
}

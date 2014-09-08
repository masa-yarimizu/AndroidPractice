package com.example.yarimizuverse.activity;

import com.example.yarimizuverse.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageViewActivity extends Activity {
	private Bitmap img = null; 
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview);
        
        ImageView imgView = (ImageView)findViewById(R.id.imageView1);

        imgView.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				
				if ( event.getAction() == MotionEvent.ACTION_DOWN) {
					
					finish();
					
				}
				return false;
			}
		});
        
    }
}

package com.example.activitysample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ImageViewActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		//スーパークラスのonCreateを呼び出す
		super.onCreate(savedInstanceState);
		
		// コンテントビューに"imageview.xml"セットする
		setContentView(R.layout.imageview);
		
		//インテントから値を取得する
		Intent intent = getIntent();
		int resourceID = intent.getIntExtra("resourceID", 0);
		
		//　値が取得できていれば、その値をもとにImageViewに画像をセットする
		if (resourceID != 0) {
			
			ImageView imageView = (ImageView)findViewById(R.id.imageView);
			imageView.setImageBitmap( BitmapFactory.decodeResource(getResources(), resourceID));
			
			imageView.setOnClickListener( new View.OnClickListener() {
				
				@Override
				public void onClick(View view) {
					// TODO Auto-generated method stub
					finish();
				}
			});
		}
		
	}
}

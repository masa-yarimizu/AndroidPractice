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
		
		//�X�[�p�[�N���X��onCreate���Ăяo��
		super.onCreate(savedInstanceState);
		
		// �R���e���g�r���[��"imageview.xml"�Z�b�g����
		setContentView(R.layout.imageview);
		
		//�C���e���g����l���擾����
		Intent intent = getIntent();
		int resourceID = intent.getIntExtra("resourceID", 0);
		
		//�@�l���擾�ł��Ă���΁A���̒l�����Ƃ�ImageView�ɉ摜���Z�b�g����
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

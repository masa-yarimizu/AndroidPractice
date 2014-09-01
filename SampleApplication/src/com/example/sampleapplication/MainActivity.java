package com.example.sampleapplication;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity {
	
	//�摜��ێ����郁���o�ϐ�
	private Bitmap yarimizu = null;
	private Bitmap yarimizu2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	//�X�[�p�[�N���X��onCreate���Ăяo��
        super.onCreate(savedInstanceState);
        //�R���e���g�r���[�Ƀ��C�A�E�g���\�[�X���Z�b�g����
        setContentView(R.layout.activity_main);
        //yarimizu��yarimizu2��Bitmap�ɕϊ�����
        yarimizu = BitmapFactory.decodeResource(getResources(), R.drawable.yarimizu_mountain);
        yarimizu2 = BitmapFactory.decodeResource(getResources(), R.drawable.images);
        
        RelativeLayout relativeLayout = new RelativeLayout(this);
        
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(
        		ViewGroup.LayoutParams.MATCH_PARENT,
        		ViewGroup.LayoutParams.MATCH_PARENT));
        
        setContentView(relativeLayout);
        
        ImageView imageView = new ImageView(this);
        
        imageView.setImageBitmap(yarimizu);
        
        imageView.setId(1);
        
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
        		ViewGroup.LayoutParams.WRAP_CONTENT,
        		ViewGroup.LayoutParams.WRAP_CONTENT);
        
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.addRule(RelativeLayout.CENTER_VERTICAL);
        
        imageView.setLayoutParams(params);
        
        
    }
    
    //�����̃{�^�����������Ƃ��ɌĂяo����郁�\�b�h
    public void onClick1(View view) {
    	//ImageView���擾
    	ImageView imageView = (ImageView)findViewById(R.id.imageView1);
    	
    	//ImageView��yarimizu���Z�b�g����
    	imageView.setImageBitmap(yarimizu);
    }
    
    //�E���̃{�^�����������Ƃ��ɌĂяo����郁�\�b�h
    public void onClick2(View view) {
    	//ImageView���擾
    	ImageView imageView = (ImageView)findViewById(R.id.imageView1);
    	
    	//ImageView��yarimizu���Z�b�g����
    	imageView.setImageBitmap(yarimizu2);
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
}

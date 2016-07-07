package com.example.bigwheeldemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends Activity implements OnClickListener{
	private Button mBtn_1,mBtn_2,mBtn_3;
	@Override	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}
	
	public void init(){
		mBtn_1 = (Button)findViewById(R.id.btn_bigWheel);
		mBtn_2 = (Button)findViewById(R.id.btn_LuckyOneView);
		mBtn_3 = (Button)findViewById(R.id.btn_LuckyTwoView);
		mBtn_1.setOnClickListener(this);
		mBtn_2.setOnClickListener(this);
		mBtn_3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_bigWheel:
			BigWheelActivity.startActivity(this);
			break;
		case R.id.btn_LuckyOneView:
			LuckyOneActivity.startActivity(this);
			break;
		case R.id.btn_LuckyTwoView:
			LuckyTwoActivity.startActivity(this);
			break;
		default:
			break;
		}
	}
}

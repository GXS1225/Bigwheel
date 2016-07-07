package com.example.bigwheeldemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class LuckyTwoActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_luckytwo);
	}
	public static void startActivity(Context context){
		Intent intent = new Intent(context, LuckyTwoActivity.class);
		context.startActivity(intent);
	}
}

package com.example.bigwheeldemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class LuckyOneActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_luckyone);
	}
	public static void startActivity(Context context){
		Intent intent = new Intent(context, LuckyOneActivity.class);
		context.startActivity(intent);
	}
}

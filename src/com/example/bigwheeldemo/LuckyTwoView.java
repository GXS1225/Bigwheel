package com.example.bigwheeldemo;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LuckyTwoView extends LinearLayout implements Runnable {
	private Context mContext;
	private TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9;
	private int position;
	private Runnable mRunnable;
	private Thread mThread;
	private String[] mStrs = new String[] { "单反相机", "IPAD", "恭喜发财", "IPHONE",
			"妹子一只", "恭喜发财","妹子一只", "恭喜发财" };
	private int mAwardPosition = 	(int)(Math.random()*10+30);
	private boolean isRun ;
	private long mSpeed = 300;
	public LuckyTwoView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		initView();
	}

	public LuckyTwoView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		initView();
	}

	public LuckyTwoView(Context context) {
		super(context);
		mContext = context;
		initView();
	}

	public void initView() {
		View view = LayoutInflater.from(mContext).inflate(R.layout.item2, this);
		mRunnable = this;
		
		tv1 = (TextView) findViewById(R.id.tv1);
		tv2 = (TextView) findViewById(R.id.tv2);
		tv3 = (TextView) findViewById(R.id.tv3);
		tv4 = (TextView) findViewById(R.id.tv4);
		tv5 = (TextView) findViewById(R.id.tv5);
		tv6 = (TextView) findViewById(R.id.tv6);
		tv7 = (TextView) findViewById(R.id.tv7);
		tv8 = (TextView) findViewById(R.id.tv8);
		tv9 = (TextView) findViewById(R.id.tv9);
		tv5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mThread == null) {
					mThread = new Thread(mRunnable);
					isRun = true;
					mThread.start();
				}
			}
		});
	}

	private Handler mHandler = new Handler();

	@Override
	public void run() {
		
		
		while (isRun) {
			position++;
			int count = position % 8;
			switch (count) {
			case 0:
				mHandler.post(new Runnable() {

					@Override
					public void run() {
						tv1.setBackgroundResource(R.drawable.sign_award_noget);
						tv2.setBackgroundResource(R.drawable.sign_award_noget);
						tv3.setBackgroundResource(R.drawable.sign_award_noget);
						tv4.setBackgroundResource(R.drawable.sign_award_get);
						tv6.setBackgroundResource(R.drawable.sign_award_noget);
						tv7.setBackgroundResource(R.drawable.sign_award_noget);
						tv8.setBackgroundResource(R.drawable.sign_award_noget);
						tv9.setBackgroundResource(R.drawable.sign_award_noget);

					}
				});
				break;
			case 1:
				mHandler.post(new Runnable() {

					@Override
					public void run() {
						tv1.setBackgroundResource(R.drawable.sign_award_get);
						tv2.setBackgroundResource(R.drawable.sign_award_noget);
						tv3.setBackgroundResource(R.drawable.sign_award_noget);
						tv4.setBackgroundResource(R.drawable.sign_award_noget);
						tv6.setBackgroundResource(R.drawable.sign_award_noget);
						tv7.setBackgroundResource(R.drawable.sign_award_noget);
						tv8.setBackgroundResource(R.drawable.sign_award_noget);
						tv9.setBackgroundResource(R.drawable.sign_award_noget);
						tv1.setTextColor(Color.RED);
						tv2.setTextColor(Color.BLACK);
						tv3.setTextColor(Color.BLACK);
						tv4.setTextColor(Color.BLACK);
						tv6.setTextColor(Color.BLACK);
						tv7.setTextColor(Color.BLACK);
						tv8.setTextColor(Color.BLACK);
						tv9.setTextColor(Color.BLACK);

					}
				});
				break;
			case 2:
				mHandler.post(new Runnable() {

					@Override
					public void run() {
						tv1.setBackgroundResource(R.drawable.sign_award_noget);
						tv2.setBackgroundResource(R.drawable.sign_award_get);
						tv3.setBackgroundResource(R.drawable.sign_award_noget);
						tv4.setBackgroundResource(R.drawable.sign_award_noget);
						tv6.setBackgroundResource(R.drawable.sign_award_noget);
						tv7.setBackgroundResource(R.drawable.sign_award_noget);
						tv8.setBackgroundResource(R.drawable.sign_award_noget);
						tv9.setBackgroundResource(R.drawable.sign_award_noget);

					}
				});
				break;
			case 3:
				mHandler.post(new Runnable() {

					@Override
					public void run() {
						tv1.setBackgroundResource(R.drawable.sign_award_noget);
						tv2.setBackgroundResource(R.drawable.sign_award_noget);
						tv3.setBackgroundResource(R.drawable.sign_award_get);
						tv4.setBackgroundResource(R.drawable.sign_award_noget);
						tv6.setBackgroundResource(R.drawable.sign_award_noget);
						tv7.setBackgroundResource(R.drawable.sign_award_noget);
						tv8.setBackgroundResource(R.drawable.sign_award_noget);
						tv9.setBackgroundResource(R.drawable.sign_award_noget);

					}
				});
				break;
			case 4:
				mHandler.post(new Runnable() {

					@Override
					public void run() {
						tv1.setBackgroundResource(R.drawable.sign_award_noget);
						tv2.setBackgroundResource(R.drawable.sign_award_noget);
						tv3.setBackgroundResource(R.drawable.sign_award_noget);
						tv4.setBackgroundResource(R.drawable.sign_award_noget);
						tv6.setBackgroundResource(R.drawable.sign_award_get);
						tv7.setBackgroundResource(R.drawable.sign_award_noget);
						tv8.setBackgroundResource(R.drawable.sign_award_noget);
						tv9.setBackgroundResource(R.drawable.sign_award_noget);

					}
				});
				break;
			case 5:
				mHandler.post(new Runnable() {

					@Override
					public void run() {
						tv1.setBackgroundResource(R.drawable.sign_award_noget);
						tv2.setBackgroundResource(R.drawable.sign_award_noget);
						tv3.setBackgroundResource(R.drawable.sign_award_noget);
						tv4.setBackgroundResource(R.drawable.sign_award_noget);
						tv6.setBackgroundResource(R.drawable.sign_award_noget);
						tv7.setBackgroundResource(R.drawable.sign_award_noget);
						tv8.setBackgroundResource(R.drawable.sign_award_noget);
						tv9.setBackgroundResource(R.drawable.sign_award_get);

					}
				});
				break;
			case 6:
				mHandler.post(new Runnable() {

					@Override
					public void run() {
						tv1.setBackgroundResource(R.drawable.sign_award_noget);
						tv2.setBackgroundResource(R.drawable.sign_award_noget);
						tv3.setBackgroundResource(R.drawable.sign_award_noget);
						tv4.setBackgroundResource(R.drawable.sign_award_noget);
						tv6.setBackgroundResource(R.drawable.sign_award_noget);
						tv7.setBackgroundResource(R.drawable.sign_award_noget);
						tv8.setBackgroundResource(R.drawable.sign_award_get);
						tv9.setBackgroundResource(R.drawable.sign_award_noget);

					}
				});
				break;
			case 7:
				mHandler.post(new Runnable() {

					@Override
					public void run() {
						tv1.setBackgroundResource(R.drawable.sign_award_noget);
						tv2.setBackgroundResource(R.drawable.sign_award_noget);
						tv3.setBackgroundResource(R.drawable.sign_award_noget);
						tv4.setBackgroundResource(R.drawable.sign_award_noget);
						tv6.setBackgroundResource(R.drawable.sign_award_noget);
						tv7.setBackgroundResource(R.drawable.sign_award_get);
						tv8.setBackgroundResource(R.drawable.sign_award_noget);
						tv9.setBackgroundResource(R.drawable.sign_award_noget);

					}
				});
				break;

			default:
				break;
			}
			try {
				postInvalidate();
				Thread.sleep(mSpeed);
				isRun = position < mAwardPosition?true:false;
				if (!isRun) {
					mThread.interrupt();
					mThread = null;
					position = 0;
					mAwardPosition = (int)(Math.random()*10+30);
					mHandler.post(new Runnable() {

						@Override
						public void run() {
							Toast.makeText(mContext, "我是第" + mStrs[position%8], 1000).show();
						}
					});
					
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

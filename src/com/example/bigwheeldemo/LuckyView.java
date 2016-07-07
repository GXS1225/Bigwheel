package com.example.bigwheeldemo;

import java.util.Random;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LuckyView extends LinearLayout implements Runnable,OnTouchListener{
	private Context mContext;
	private AttributeSet mAttrs;
	private int mItemSize = 9;
	/**
	 * 抽奖的文字
	 */
	private String[] mStrs = new String[] { "单反相机", "IPAD", "恭喜发财", "IPHONE",
			"妹子一只", "恭喜发财","妹子一只", "恭喜发财","妹子一只" };
	/**
	 * 每个盘块的颜色
	 */
	private int[] mColors = new int[] { 0xFFFFC300, 0xFFF17E01, 0xFFFFC300,
			0xFFF17E01, 0xFFFFC300, 0xFFF17E01,0xFFF17E01, 0xFFFFC300, 0xFFF17E01 };
	/**
	 * 与文字对应的图片
	 */
	private int[] mImgs = new int[] { R.drawable.danfan, R.drawable.ipad,
			R.drawable.f040, R.drawable.iphone, R.drawable.meizi,
			R.drawable.f040 , R.drawable.iphone, R.drawable.meizi,
			R.drawable.f040};
	public static final int MESSAGE_9 = 9;
	public static final int MESSAGE_1 = 1;
	public static final int MESSAGE_2 = 2;
	public static final int MESSAGE_3 = 3;
	public static final int MESSAGE_4 = 4;
	public static final int MESSAGE_5 = 5;
	public static final int MESSAGE_6 = 6;
	public static final int MESSAGE_7 = 7;
	public static final int MESSAGE_8 = 8;
	
	public static final int MESSAGE_11 = 11;
	public static final int MESSAGE_22 = 22;
	public static final int MESSAGE_33 = 33;
	public static final int MESSAGE_44 = 44;
	public static final int MESSAGE_55 = 55;
	public static final int MESSAGE_66 = 66;
	public static final int MESSAGE_77 = 77;
	public static final int MESSAGE_88 = 88;
	
	public static final int MESSAGE_STOP = 10;
	
	boolean IsLongPressed = false;
	int flag = 1;
	int number = 8;
	TextView tv1;
	TextView tv2;
	TextView tv3;
	TextView tv4;
	TextView tv5;
	TextView tv6;
	TextView tv7;
	TextView tv8;
	TextView tv9;
	ImageView iv;
	int width;
	int height;
	Bitmap wheel;
	Bitmap wheel1;
	Bitmap wheel2;
	Bitmap wheel3;
	Bitmap wheel4;
	Bitmap wheel5;
	Bitmap wheel6;
	Bitmap wheel7;
	Bitmap wheel8;
	Handler handler;


	public LuckyView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		mAttrs = attrs;
		init();
	}

	public LuckyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		mAttrs = attrs;
		init();
	}
	public LuckyView(Context context) {
		super(context);
		mContext = context;
		init();
	}
	
	public void init(){
		setOrientation(VERTICAL);
		TypedArray array = mContext.obtainStyledAttributes(mAttrs, R.styleable.LuckyView);
		mItemSize = array.getInt(R.styleable.LuckyView_size, 0);
		View view = LayoutInflater.from(mContext).inflate(R.layout.item, this);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        tv5 = (TextView)findViewById(R.id.tv5);
        tv6 = (TextView)findViewById(R.id.tv6);
        tv7 = (TextView)findViewById(R.id.tv7);
        tv8 = (TextView)findViewById(R.id.tv8);
        tv9 = (TextView)findViewById(R.id.tv9);
        tv1.setBackgroundResource(mImgs[0]);
        tv2.setBackgroundResource(mImgs[1]);
        tv3.setBackgroundResource(mImgs[2]);
        tv4.setBackgroundResource(mImgs[3]);
        tv5.setBackgroundResource(mImgs[4]);
        tv6.setBackgroundResource(mImgs[5]);
        tv7.setBackgroundResource(mImgs[6]);
        tv8.setBackgroundResource(mImgs[7]);
        tv1.setText(mStrs[0]);
        tv2.setText(mStrs[1]);
        tv3.setText(mStrs[2]);
        tv4.setText(mStrs[3]);
        tv5.setText(mStrs[4]);
        tv6.setText(mStrs[5]);
        tv7.setText(mStrs[6]);
        tv8.setText(mStrs[7]);
        tv9.setText("Run");
        tv9.setOnTouchListener(this);
        iv = (ImageView)findViewById(R.id.iv);
        
        WindowManager wm=(WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);  
        width=wm.getDefaultDisplay().getWidth();       //手机屏幕的宽度  
        height=wm.getDefaultDisplay().getHeight()+90;      //手机屏幕的高度
        
        wheel = BitmapFactory.decodeResource(getResources(), R.drawable.wheel);
        wheel1 = BitmapFactory.decodeResource(getResources(), R.drawable.wheel1);
        wheel2 = BitmapFactory.decodeResource(getResources(), R.drawable.wheel2);
        wheel3 = BitmapFactory.decodeResource(getResources(), R.drawable.wheel3);
        wheel4 = BitmapFactory.decodeResource(getResources(), R.drawable.wheel4);
        wheel5 = BitmapFactory.decodeResource(getResources(), R.drawable.wheel5);
        wheel6 = BitmapFactory.decodeResource(getResources(), R.drawable.wheel6);
        wheel7 = BitmapFactory.decodeResource(getResources(), R.drawable.wheel7);
        wheel8 = BitmapFactory.decodeResource(getResources(), R.drawable.wheel8);
	}
	

	@Override
	public void run() {
		
	}
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
            case MESSAGE_1:
            	iv.setImageBitmap(wheel1);
                tv1.setText(mStrs[MESSAGE_1-1]);
                break;
            case MESSAGE_2:
            	iv.setImageBitmap(wheel2);
                tv2.setText(mStrs[MESSAGE_2-1]);
                break;
            case MESSAGE_3:
            	iv.setImageBitmap(wheel3);
                tv3.setText(mStrs[MESSAGE_3-1]);
                break;
            case MESSAGE_4:
            	iv.setImageBitmap(wheel4);
                tv4.setText(mStrs[MESSAGE_4-1]);
                break;
            case MESSAGE_5:
            	iv.setImageBitmap(wheel5);
                tv5.setText(mStrs[MESSAGE_5-1]);
                break;
            case MESSAGE_6:
            	iv.setImageBitmap(wheel6);
                tv6.setText(mStrs[MESSAGE_6-1]);
                break;
            case MESSAGE_7:
            	iv.setImageBitmap(wheel7);
                tv7.setText(mStrs[MESSAGE_7-1]);
                break;
            case MESSAGE_8:
            	iv.setImageBitmap(wheel8);
                tv8.setText(mStrs[MESSAGE_8-1]);
                break;
                
            case MESSAGE_11:
            	flag = 1;
//            	dialog();
                break;
            case MESSAGE_22:
            	flag = 2;
//            	dialog();
                break;
            case MESSAGE_33:
            	flag = 3;
//            	dialog();
                break;
            case MESSAGE_44:
            	flag = 4;
//            	dialog();
                break;
            case MESSAGE_55:
            	flag = 5;
//            	dialog();
                break;
            case MESSAGE_66:
            	flag = 6;
//            	dialog();
                break;
            case MESSAGE_77:
            	flag = 7;
//            	dialog();
                break;
            case MESSAGE_88:
            	flag = 8;
//            	dialog();
                break;
                
            case MESSAGE_STOP:
            	Bundle bundle = new Bundle();
            	bundle = msg.getData();
            	int i = bundle.getInt("msg");
            	tv9.setText("RUN");
            	switch (i%8) {
				case 0:
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
					
				default:
					break;
				}
            	
                break;
            	
            }
        }
    };
 

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		Message msg = new Message();
 	   
    	if(event.getAction()==MotionEvent.ACTION_DOWN){
    		//zhongjian
    			tv9.setText("RUNNING");
    			Random random = new Random();
    			number = random.nextInt((8))+1;
    			Log.i("chz",""+number);
    			new Thread(new Runnable() {
        			public void run() {
        				Random random = new Random();
            			int num = random.nextInt((8));
            			Log.i("chz",""+(num+3));
        				while(number<60+num){
        					Message message = new Message();
        					switch (number%8) {
        					case 0:
        						message.what = MESSAGE_8;
        						break;
        					case 1:
        						message.what = MESSAGE_1;
        						break;
        					case 2:
        						message.what = MESSAGE_2;
        						break;
        					case 3:
        						message.what = MESSAGE_3;
        						break;
        					case 4:
        						message.what = MESSAGE_4;
        						break;
        					case 5:
        						message.what = MESSAGE_5;
        						break;
        					case 6:
        						message.what = MESSAGE_6;
        						break;
        					case 7:
        						message.what = MESSAGE_7;
        						break;
        					case 8:
        						message.what = MESSAGE_8;
        						break;
        					default:
        						break;
        				}
    					number++;
//    					Bundle bundle = new Bundle();
//    		    		bundle.putString("msg", "chzlovehp");
//    		    		message.setData(bundle);
    			    	mHandler.sendMessage(message);
        			    if(number<50){	
	    			    	try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
        			    }else if(number>50 && number<60){
        			    	try {
								Thread.sleep(300);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
        			    }else{
        			    	try {
								Thread.sleep(400);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
        			    }
        			}

    				Message message = new Message();
    				message.what = MESSAGE_STOP;
    				Bundle bundle = new Bundle();
		    		bundle.putInt("msg", (num+3));
		    		message.setData(bundle);
        			mHandler.sendMessage(message);
        		}
        	}).start(); 
	    	mHandler.sendMessage(msg);
    }
		return false;
	}
}

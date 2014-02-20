package com.example.alarmtube;

import java.util.Random;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CountDown extends Activity {

	Button start;
	MyCount mc;
	Random randGenerator;
	long delay;
	PendingIntent alarmIntent;
	AlarmManager alarmManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("TAGG","made it here");
		setContentView(R.layout.count_down);
		start = (Button) findViewById(R.id.start);
		start.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				startYoutube();
			}
		});
		
		mc = new MyCount(10000, 100);
		mc.start();
		
		Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
		 // Vibrate for 1500 milliseconds
		 v.vibrate(500);
		
		MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.three_of_us);
		mediaPlayer.start(); 
		
		SharedPreferences pref = getSharedPreferences("ONE",Context.MODE_PRIVATE);
		Editor editor = pref.edit();
		int at =  pref.getInt("COUNT", 0);
	    editor.putInt("COUNT",at+1);
	    editor.commit();
	    
	    FriendDataManager fdm = new FriendDataManager();
	    BigDaddy.friendData = fdm.getFriend(at);
	    BigDaddy.wrong1 = fdm.getWrong(at);
	    while ( BigDaddy.friendData.name.equals(BigDaddy.wrong1)){
	    	BigDaddy.wrong1= fdm.getWrong(at);
	    }
	    BigDaddy.wrong2= fdm.getWrong(at);
	    while (BigDaddy.wrong1.equals(BigDaddy.wrong2) || BigDaddy.friendData.name.equals(BigDaddy.wrong2)){
	    	 BigDaddy.wrong2= fdm.getWrong(at);
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.count_down, menu);
		return true;
	}
	
	// countdowntimer is an abstract class, so extend it and fill in methods
    public class MyCount extends CountDownTimer {

        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
        	startYoutube();
        	Log.i("count","finsih");
        }

		@Override
        public void onTick(long millisUntilFinished) {
			start.setText("零");
			start.setText("一");
			start.setText("二");
			start.setText("三");
			start.setText("四");
			start.setText("五");
			start.setText("六");
			start.setText("七");
			start.setText("八");
			start.setText("九");
			start.setText("十");
			
			start.setText("Video in: " + toChi((int)(millisUntilFinished / 1000)));
        }

		private String toChi(int num) {
			switch (num){
			case 0:
				return "零";
			case 1:
				return "一";
			case 2:
				return "二";
			case 3:
				return "三";	
			case 4:
				return "四";
			case 5:
				return "五";
			case 6:
				return "六";
			case 7:
				return "七";
			case 8:
				return "八";
			case 9:
				return "九";
			case 10:
				return "十";
			}
			return "??";
		}
    }
    
    private void startYoutube() {
    	
    	randGenerator = new Random();
		delay = randGenerator.nextLong();
		delay = (5*delay)+2;
		delay = delay * 60000; //convert to milliseconds
		
		Intent myIntent = new Intent(this, DLAlarmReciever.class);
		myIntent.putExtra("showQuiz",true);
		alarmIntent = PendingIntent.getBroadcast(this, 1, myIntent, PendingIntent.FLAG_ONE_SHOT);
		alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+100000, alarmIntent);
    	
    	Intent intent = new Intent(this, DaTube.class);
    	startActivity(intent);
    	
    	finish();
	}

}

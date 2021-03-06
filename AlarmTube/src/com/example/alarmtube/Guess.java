package com.example.alarmtube;

import java.util.ArrayList;
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

public class Guess extends Activity {
	MediaPlayer mediaPlayer;
	MyCount count;
	Vibrator v;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guess);
		
		Log.e("QUIZZING","QUIZZING");
		
		ArrayList<Button> butts = new ArrayList<Button>();
		butts.add((Button)findViewById(R.id.translate));
		butts.add((Button)findViewById(R.id.button2));
		butts.add((Button)findViewById(R.id.button3));
		
		Button good = getButt(butts);
		good.setText(BigDaddy.friendData.name);
		Button bad1 = getButt(butts);
		bad1.setText(BigDaddy.wrong1);
		Button bad2 = getButt(butts);
		bad2.setText(BigDaddy.wrong2);
		
		count = new MyCount(10000,10000);
		count.start();
		
		mediaPlayer = MediaPlayer.create(this, R.raw.beep);
		mediaPlayer.start();
		
		v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
		v.vibrate(1000);
		
	}

	private Button getButt(ArrayList<Button> butts) {
		int roll = (int)Math.floor(Math.random()*(butts.size()));
		Button result = butts.get(roll);
		butts.remove(roll);
		
		result.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view) {
				SharedPreferences pref;
				Editor editor;
				if (((Button)view).getText().equals(BigDaddy.friendData.name)){
					pref = getSharedPreferences("ONE",Context.MODE_PRIVATE);
					editor = pref.edit();
				    editor.putInt("RIGHT",pref.getInt("RIGHT", 0)+1);
				    editor.commit();
				}else{
					pref = getSharedPreferences("ONE",Context.MODE_PRIVATE);
					editor = pref.edit();
				    editor.putInt("WRONG",pref.getInt("WRONG", 0)+1);
				    editor.commit();
				}
				nextAct();
			}
		});
		return result;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void nextAct() {
    	Intent intent = new Intent(this, Message.class);
    	startActivity(intent);
    	finish();
	}
	
	@Override
	public void onPause(){
		super.onPause();
		//mediaPlayer.stop();
	}
	
	 public class MyCount extends CountDownTimer {

	        public MyCount(long millisInFuture, long countDownInterval) {
	        	super(millisInFuture, countDownInterval);
	        }

	        @Override
	        public void onFinish() {
	        	finish();
	        }

			@Override
			public void onTick(long arg0) {
				// TODO Auto-generated method stub
				
			}
	 }
}

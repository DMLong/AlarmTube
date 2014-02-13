package com.example.alarmtube;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CountDown extends Activity {

	Button start;
	MyCount mc;
	
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
		MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.three_of_us);
		mediaPlayer.start(); 
		
		SharedPreferences pref = getSharedPreferences("COUNT",Context.MODE_PRIVATE);
		Editor editor = pref.edit();
		int at =  pref.getInt("COUNT", 0);
	    editor.putInt("COUNT",at+1);
	    editor.commit();
	    
	    FriendDataManager fdm = new FriendDataManager();
	    BigDaddy.friendData = fdm.getFriend(at);
	    BigDaddy.wrong1 = fdm.getWrong(at);
	    BigDaddy.wrong2= fdm.getWrong(at);
	    while (BigDaddy.wrong1.equals(BigDaddy.wrong2)){
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
        	start.setText("Video in: " + millisUntilFinished / 1000);
        }
    }
    
    private void startYoutube() {
    	Intent intent = new Intent(this, DaTube.class);
    	startActivity(intent);
	}

}

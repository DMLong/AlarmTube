package com.example.alarmtube;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CountDown extends Activity {

	Button start;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.count_down);
		start = (Button) findViewById(R.id.start);
		start.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				startYoutube();
			}
		});
		
		MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sound_file_1);
		mediaPlayer.start(); // no need to call prepare(); create() does that for you
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
        }

		@Override
        public void onTick(long millisUntilFinished) {
        	start.setText("Left: " + millisUntilFinished / 1000);
        }
    }
    
    private void startYoutube() {
		// TODO Auto-generated method stub
		
	}

}

package com.example.alarmtube;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
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
        	Log.i("count","finsih");
        }

		@Override
        public void onTick(long millisUntilFinished) {
        	start.setText("Video in: " + millisUntilFinished / 1000);
        }
    }
    
    private void startYoutube() {
    	 startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.youtube.com/watch?v=Hxy8BZGQ5Jo")));
    	    Log.i("Video", "Video Playing....");
		
	}

}

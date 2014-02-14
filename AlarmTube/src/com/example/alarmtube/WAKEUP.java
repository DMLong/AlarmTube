package com.example.alarmtube;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WAKEUP extends Activity {

	PendingIntent alarmIntent;
	AlarmManager alarmManager;
	MediaPlayer mediaPlayer;
	
	Button off;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wakeup);
		
		mediaPlayer = MediaPlayer.create(this, R.raw.three_of_us);
		mediaPlayer.start(); 
		
		
		off = (Button) findViewById(R.id.off);
		off.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				mediaPlayer.stop();
			}
		});
		
		Intent myIntent = new Intent(this, DLAlarmReciever.class);
		myIntent.putExtra("startCountDown",true);
		alarmIntent = PendingIntent.getBroadcast(this, 1, myIntent, PendingIntent.FLAG_ONE_SHOT);
		alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+20000, alarmIntent);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wakeu, menu);
		return true;
	}

}

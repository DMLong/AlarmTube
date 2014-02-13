package com.example.alarmtube;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class Message extends Activity {
	TextView message;
	TextView percent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
		message= (TextView)findViewById(R.id.message);
		percent= (TextView)findViewById(R.id.percent);
		message.setText(BigDaddy.friendData.message);
		SharedPreferences pref = getSharedPreferences("ONE",Context.MODE_PRIVATE);
		int right = pref.getInt("RIGHT", 0);
		Log.i("good",right+"");
	    int wrong = pref.getInt("WRONG", 0);
	    Log.i("bad",wrong+"");
	    percent.setText("percent right: "+ (float)right/(float)(right +wrong));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

package com.example.alarmtube;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class Message extends Activity {
	TextView message;
	TextView percent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
		message= (Button)findViewById(R.id.message);
		percent= (Button)findViewById(R.id.percent);
		message.setText(BigDaddy.friendData.message);
		SharedPreferences pref = getSharedPreferences("COUNT",Context.MODE_PRIVATE);
		int right = pref.getInt("COUNT", 0);
	    int wrong = pref.getInt("COUNT", 0);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

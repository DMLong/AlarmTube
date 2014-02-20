package com.example.alarmtube;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Message extends Activity {
	TextView message;
	TextView percent;
	Button translate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
		translate = (Button)findViewById(R.id.translate);
		message= (TextView)findViewById(R.id.message);
		percent= (TextView)findViewById(R.id.percent);
		message.setText(BigDaddy.friendData.message);
		SharedPreferences pref = getSharedPreferences("ONE",Context.MODE_PRIVATE);
		int right = pref.getInt("RIGHT", 0);
		Log.i("good",right+"");
	    int wrong = pref.getInt("WRONG", 0);
	    Log.i("bad",wrong+"");
	    percent.setText("percent right: "+ (float)right/(float)(right +wrong));
	    translate.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				message.setText(BigDaddy.friendData.enMessage);
			}
	    });
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

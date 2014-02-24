package com.example.alarmtube;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class DLAlarmReciever extends BroadcastReceiver {

	Intent myIntent;

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		WakeLocker.acquire(context);

		Log.e("tag","recieved! "+intent.getBooleanExtra("startCountDown", false));
		
		if (intent.getBooleanExtra("showQuiz", false)) { //if showQuiz was added as an extra...
			myIntent = new Intent(context, Guess.class);
			myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(myIntent);
		} else {

			Log.e("tag", "went off");
			myIntent = new Intent(context, CountDown.class);
			myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(myIntent);
		}

	}

}

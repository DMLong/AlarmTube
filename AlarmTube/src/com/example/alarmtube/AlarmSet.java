package com.example.alarmtube;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TimePicker;
import android.widget.ToggleButton;

public class AlarmSet extends Activity {
	
	TimePicker timeSelector;
	AlarmManager alarmManager;
    PendingIntent alarmIntent; 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_set);
        
        timeSelector = (TimePicker) findViewById(R.id.timePicker);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_alarm_set, menu);
        return true;
    }
    
    public void toggleOnOff(View view){
    	Calendar calendar;
    	
    	TimePicker timepicker = (TimePicker) findViewById(R.id.timePicker);
    	
    	// Is the toggle on?
    	boolean on = ((ToggleButton) view).isChecked();
        
        
        
        if (on) {
            Log.e("test","ON");
            
            Intent i = new Intent(this, DLAlarmReciever.class);
            //alarmIntent = PendingIntent.getBroadcast(this, requestCode, intent, flags)()
            
            calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, timeSelector.getCurrentHour());
            calendar.set(Calendar.MINUTE, timeSelector.getCurrentMinute());
            
            //get the object
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            //alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), intentAlarm);
        } else {
            Log.e("test","OFF");
        }

    }
}

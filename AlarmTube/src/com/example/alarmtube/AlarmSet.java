package com.example.alarmtube;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.ToggleButton;

public class AlarmSet extends Activity {
	
	TimePicker timeSelector;

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
    	// Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();
        
        if (on) {
            Log.e("test","ON");
            //Intent intentAlarm = new Intent(this, AlarmReciever.class);
            //get the object
            //AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            //alarmManager.set(AlarmManager.RTC_WAKEUP, timeSelecstor., operation)
        } else {
            Log.e("test","OFF");
        }

    }
}

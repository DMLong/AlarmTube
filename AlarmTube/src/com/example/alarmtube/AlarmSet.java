package com.example.alarmtube;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TimePicker;
import android.widget.ToggleButton;

public class AlarmSet extends Activity {
	
	TimePicker timeSelector;
	AlarmManager alarmManager;
    PendingIntent alarmIntent; 
    Intent i;
    long offset;
    private static Bundle bundle = new Bundle();
    private ToggleButton toggleButton;

    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_set);
        
        timeSelector = (TimePicker) findViewById(R.id.timePicker);
        toggleButton = (ToggleButton)findViewById(R.id.toggleAlarm);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_alarm_set, menu);
        return true;
    }
    
    @Override
    public void onPause(){
    	super.onPause();
    	bundle.putBoolean("ToggleButtonState", toggleButton.isChecked());  	
    }
    
    @Override
    public void onResume() {
        super.onResume();
        toggleButton.setChecked(bundle.getBoolean("ToggleButtonState",false));
    }
    
    public void toggleOnOff(View view){
    	long curTime;
    	long alarmTime;
    	
    	// Is the toggle on?
    	boolean on = ((ToggleButton) view).isChecked();
        
        
        if (on) {
            Log.e("test","ON");
            
            timeSelector.setEnabled(false);
            Intent i = new Intent(this, DLAlarmReciever.class);
            alarmIntent = PendingIntent.getBroadcast(this, 1, i, PendingIntent.FLAG_UPDATE_CURRENT);
            
            Log.e("hr",""+timeSelector.getCurrentHour());
            Log.e("min",""+timeSelector.getCurrentMinute());
            
            curTime=System.currentTimeMillis();
            //curTime= new GregorianCalendar().getTimeInMillis();
            curTime = (curTime-(3600*6*1000))%(3600*24*1000); //TODO change that - to a + and 6 to an 8 for china timezones
            alarmTime = (60*1000*timeSelector.getCurrentMinute())+(3600*1000*timeSelector.getCurrentHour());
            
            Log.e("curTime","curTime "+curTime);
            Log.e("alarmTime","alarmTime "+alarmTime);
            
            if (alarmTime > curTime){
            	offset = alarmTime-curTime;
            } else{
            	offset = (alarmTime+(24*3600*1000)-curTime);
            }
            

            Log.e("offset","offset "+offset);
            //get the object
            Log.e("AAA","SANITY CHECK");
            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+offset, alarmIntent);
        } else {
            Log.e("test","OFFF");
            
            Intent i = new Intent(this, DLAlarmReciever.class);
            //i.putExtra("startCountdown", false);
            alarmIntent = PendingIntent.getBroadcast(this, 1, i, PendingIntent.FLAG_ONE_SHOT);
            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            alarmManager.cancel(alarmIntent);
            
            
            timeSelector.setEnabled(true);
            //TODO cancel old pending request.t
        }
    }
}

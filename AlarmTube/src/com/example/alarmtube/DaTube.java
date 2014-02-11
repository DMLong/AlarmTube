package com.example.alarmtube;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class DaTube extends YouTubeBaseActivity implements
OnInitializedListener{
	YouTubePlayerView vid;
	String apiKey = "AIzaSyD0_ZBRWAH8XhUXRHBqCHbGbrlvuE72aPM";
	String VIDEO_ID[]={"WkaoqpfMG6Q"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		vid =new YouTubePlayerView(this);
		setContentView(vid);
		vid.initialize(apiKey, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.da_tube, menu);
		return true;
	}

	@Override
	public void onInitializationFailure(Provider arg0,
			YouTubeInitializationResult arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInitializationSuccess(Provider prov, YouTubePlayer player,
			boolean wasRestored) {
		if (!wasRestored) {
	        player.loadVideo(VIDEO_ID[getSharedPreferences("COUNT",Context.MODE_PRIVATE).getInt("COUNT", 0)]);
	      }
	}

}

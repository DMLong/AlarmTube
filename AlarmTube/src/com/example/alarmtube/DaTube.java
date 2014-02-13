package com.example.alarmtube;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class DaTube extends YouTubeBaseActivity implements
OnInitializedListener{
	YouTubePlayerView vid;
	String apiKey = "AIzaSyD0_ZBRWAH8XhUXRHBqCHbGbrlvuE72aPM";

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
	public void onInitializationSuccess(Provider prov, final YouTubePlayer player,
			boolean wasRestored) {
		if (!wasRestored) {
	        player.loadVideo(BigDaddy.friendData.vid);
	        
	        player.setPlaybackEventListener(new PlaybackEventListener(){

				@Override
				public void onBuffering(boolean arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onPaused() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onPlaying() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onSeekTo(int arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onStopped() {
					goToGuess();
				}
	        });
	      }
	}

	protected void goToGuess() {
    	Intent intent = new Intent(this, Guess.class);
    	startActivity(intent);
    	finish();
	}

}

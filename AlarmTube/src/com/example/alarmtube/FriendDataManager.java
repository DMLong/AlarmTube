package com.example.alarmtube;

import android.util.Log;

public class FriendDataManager {
	FriendData[] fd={
			new FriendData("WkaoqpfMG6Q","Colin Wielga","九","webz!")
	};

	public FriendData getFriend(int at) {
		if (at >= fd.length){
			at = (int) Math.floor(Math.random()*(fd.length));
		}
		return fd[at];
	}

	public String getWrong(int at) {
		int roll;
		/*
		 if (at >=fd.length){
			roll = (int) Math.floor(Math.random()*(fd.length));
			while (fd[roll].name.equals(BigDaddy.friendData.name)){
				roll = (int) Math.floor(Math.random()*(fd.length));
			}
			return fd[roll].name;
		}*/
		if (at >=fd.length){
			at = fd.length-1;
		}
		Log.i("at",""+at);
		roll= (int) Math.floor(Math.random()*(fd.length + 2 - (at+1))) +at+1;
		Log.i("roll",""+roll);
		if (roll == fd.length +1){
			return "Biggie";
		}else 
		if (roll == fd.length){
			return "Tupac";
		}
		return fd[at].name;
	}


}

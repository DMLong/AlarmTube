package com.example.alarmtube;

public class FriendDataManager {
	FriendData[] fd={
			new FriendData("WkaoqpfMG6Q","Colin Wielga","webz!")
	};

	public FriendData getFriend(int at) {
		if (at >= fd.length){
			at = (int) Math.floor(Math.random()*(fd.length));
		}
		return fd[at];
	}

	public String getWrong(int at) {
		int roll= (int) Math.floor(Math.random()*(fd.length + 2 - (at+1))) +at+1;
		if (roll == fd.length +1){
			return "Biggie";
		}else 
		if (roll == fd.length){
			return "Tupac";
		}
		return fd[at].name;
	}


}

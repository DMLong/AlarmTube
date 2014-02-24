package com.example.alarmtube;

import android.util.Log;

public class FriendDataManager {
	FriendData[] fd={
			new FriendData("7ImE8QV5Fs0","Stockton","KENDRICK HAD A SHWOMPS! Hope you're doing well dude. Missing you. -Stockton"),
			new FriendData("IKy_gTrdXaU","Kristin Economo","Good morning, Rhys! Just wanted to say that your energy, passion for learning, and zest for life have always inspired me! Congrats on graduating and embracing adventure. Hope China is treating you well and godspeed in 2014.-Kristin"),
			new FriendData("Awf45u6zrP0","Sam Ellerbeck","One of my favorite memories from Carleton is our Name of the Wind book club when you spent hours trying to find that one quote. Miss you buddy--can't wait to do it with book 3.-Sam"),
			new FriendData("_LiDTKEF1ek","dln","I don't know of any shortest-path algorithms that make the same decisions that you make, but keep on running most-interesting-path algorithms instead. Hope the walk was a blast, and stay in touch.-dln"),
			new FriendData("IcrbM1l_BoI","Zax","Life is an adventure! Go meet hot chicks!-zax"),
			new FriendData("W7kELFbAEpc","Sulsky","Life goal: love something half as much as this guy loved playing the piano.-Sulsky"),
			new FriendData("Rf3PCvvuAkM","Adam Segal","Turn your swag up all the way. Never go out with partial swag.-Adam"),
			new FriendData("aJuaZKBABO0","Todd Anderson","Oh my what a silly camel. You're the dude, see ya on the New York side. - Todd"),
			new FriendData("If5MF4wm1T8","Scott Levi","I don't know how to follow instructions, but I can submit 6 youtube videos (email for the list)-the editors"),
			new FriendData("l5-EwrhsMzY","Cory Fauver","Yo Rhys! Sometimes I need a pep talk in the morning too! Today is going to be awesome!-Cory"),
			new FriendData("3MteSlpxCpo&list=WLx956wrwdQHswB06FSfINgjsdL-z_tLvz","Hooker","Go learn some chinese, n00b. Have a good day Rhys!-Hooker"),
			new FriendData("W45DRy7M1no","Kevin Draper","Rhys: I'll bet you feel awkward in China sometimes because you're a tall, lanky, pasty white guy carrying your belongings around in a plastic grocery bag with a broken handle.But at least you're not this guy, right?-Draper"),
			new FriendData("4GnJ5Y5cB6I","Katie Powell","May everyday you spend in China be filled with the joy of swings."),
			new FriendData("1RVRCd6J2NA","Dhanna","How can you not wake up to black sluts? Horrible, but I had to..."),
			new FriendData("WkaoqpfMG6Q","Colin Wielga","webz!")
	};

	public FriendData getFriend(int at) {
		if (at >= fd.length){
			at = (int) Math.floor(Math.random()*(fd.length));
		}
		return fd[at];
	}

	public String getWrong(int at) {
		int roll;
		 if (at >=fd.length){
			roll = (int) Math.floor(Math.random()*(fd.length));
			while (fd[roll].name.equals(BigDaddy.friendData.name)){
				roll = (int) Math.floor(Math.random()*(fd.length));
			}
			return fd[roll].name;
		}
		Log.i("at",""+at);
		roll= (int) (Math.floor(Math.random()*(fd.length + 2 - (at+1))) +at+1);
		Log.i("roll",""+roll);
		if (roll == fd.length +1){
			return "Biggie";
		}else 
		if (roll == fd.length){
			return "Tupac";
		}
		return fd[roll].name;
	}


}

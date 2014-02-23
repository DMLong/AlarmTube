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
			new FriendData("WkaoqpfMG6Q","Colin Wielga","webz!"),
			new FriendData("Vo0Cazxj_yc","Chris Wilen","What up, Rhys!  It was either this video or 'Where the hell is Matt?'  I thought you may have already seen that one, but if not, look that up too.  Anyway, today, look around you and watch how incredible people in the world are!  I hope something really special and exciting happens!  Rise and shine, champ!  --Chris Wilen"),
			new FriendData("0P9QMkm9Eew","David Long","rise and shine! xoxo -dlong"),
			new FriendData("sD35BHWH8sg#","Andy Cochrane","'SNIPE! -Cochrane"),
			new FriendData("CM5mFH3_Qhs","Iris Cutler","We can't all be curling champions…-Iris"),
			new FriendData("gNJPEjGrJbE","Jeffrey Snyder","So this was just a placeholder video for Jeff because he can't follow directions and made his own. Email colin or david asap and we'll send it to you.  It's great."),
			new FriendData("9d8wWcJLnFI","Groenemann","I don't have a message because I'm a n00b who can't follow directions-Groenemann"),
			new FriendData("HEr1ihXM61E","Nora Sullivan","Wake up Rhys, you're in China!-Nora"),
			new FriendData("NFTaiWInZ44","Will Stratford","Rhys, I miss living with you on that side of the planet, but I hope you're keeping up the superior diet of paklep, Nutella and Toblerones.-Will"),
			new FriendData("2AKtp3XHn38", "Zach Grossnickle","To get you mind going both visually and intellectually. Keep rockin' in Chinatown. Riddle: Under Pressure is the only way I work, and by myself is the only way I'm hurt. What am I?-GNick"),
			new FriendData("c9wHWelQgYQ","Tote Hughes","I don't have a message because I'm a n00b who can't follow directions-Tote"),
			new FriendData("HJxyqFisFdY", "Ben Klibanner","I don't have a message because I'm a n00b who can't follow directions-Ben"),
			new FriendData("aQ6IVN5Yvzo", "pbob","GET UP AND PEEP SOME BIRDS!!! -Pbob"),
			new FriendData("LkCNJRfSZBU","Petey Rogers","The Rza!  Wake up you lazy bum!  Hope that Chinese is keeping you fresh, Xia Qian!-Petey"),
			new FriendData("662JyNLVpxE","Jack Mullaney","no means 'yes', yes means 'in the butt'-Jack"),
			new FriendData("Rch-092SUpQ", "Eric Alexander","Hey buddy! This seemed like a relaxing way to wake-up. Plus, Rainbow Road. Go teach 'em! -EA"),
			new FriendData("qipaFDNxF4s","Frogger","Rhys, turn around, every now and then I get a little bit terrified  and then I see the look in your eyes, turn around, bright eyes, every now and then i fall apart, and I need you now tonight, and I need more than ever.-Frogger"),
			new FriendData("cVy7YeeqGZQ","Sam Smith","You shall not pass!"),
			new FriendData("_7drlrSFeMs","Djallal","hey rhys hope you're doing well, miss you greatly and want you to know that I think of you and pray for you all the time."),
			new FriendData("j-CVp6_gCbQ","Wiensy","I don't have a message because I'm a n00b who can't follow directions-Wiensy"),
			new FriendData("V2sKH8yjVsM","Eric Manley","Get your blu-blockers on Rhys! It's a brand new day!-Manley")
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

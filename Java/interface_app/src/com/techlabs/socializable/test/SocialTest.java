package com.techlabs.socializable.test;

import com.techlabs.socializable.*;

public class SocialTest {

	public static void main(String[] args) {
		SocialTest st = new SocialTest();
		Man x = new Man();
		Boy y = new Boy();

		st.atTheParty(x);
		st.atTheParty(y);
		//st.atTheMovies(x);
		st.atTheMovies(y);
	}

	public void atTheParty(ISocializable obj) {
		obj.wish();
		obj.depart();
	}

	public void atTheMovies(IEmotionable obj) {
		obj.cry();
		obj.laugh();
	}
}

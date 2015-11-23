/**
 * TwentyTwenty class 
 * @author Girdhari
 */
package com.designpattern.assignment3;

public class TwentyTwenty extends Cricket{

	@Override
	void intializeGameType() {
		System.out.println("Twenty Twenty Match ");
	}

	@Override
	void startGame() {
		// TODO Auto-generated method stub
		System.out.println("Game Starting");
	}

	@Override
	void getGameDetails() {
		// TODO Auto-generated method stub
		System.out.println("Team A rocks");
		
	}

	@Override
	void endGame() {
		// TODO Auto-generated method stub
		System.out.println("Team B Won the match");
	}

	
}

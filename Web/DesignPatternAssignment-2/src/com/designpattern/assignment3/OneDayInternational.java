/**
 * OneDayInternational Class 
 * @author Girdhari
 */
package com.designpattern.assignment3;
public class OneDayInternational extends Cricket {
	@Override
	void intializeGameType() {
		System.out.println("ODI match between India and Australia");
	}

	@Override
	void startGame() {
		// TODO Auto-generated method stub
		System.out.println("Game Starting");
	}

	@Override
	void getGameDetails() {
		// TODO Auto-generated method stub
		System.out.println("15 Overs left");
		
	}

	@Override
	void endGame() {
		// TODO Auto-generated method stub
		System.out.println("India Won the match by 25 runs");
	}
}

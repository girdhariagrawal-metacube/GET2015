/**
 * TestCricket Class
 * @author Girdhari
 */
package com.designpattern.assignment3;
public class TestCricket extends Cricket {
	@Override
	void intializeGameType() {
		System.out.println("Match between team A and B");
	}

	@Override
	void startGame() {
		System.out.println("Match Starting");
	}

	@Override
	void getGameDetails() {
		System.out.println("Match interrupted due to rain");
		
	}

	@Override
	void endGame() {
		System.out.println("Team A won the match");
	}

}

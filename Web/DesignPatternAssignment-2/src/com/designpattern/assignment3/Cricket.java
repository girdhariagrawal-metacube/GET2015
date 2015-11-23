/**
 * Cricket abstract class
 * @author Girdhari
 */

package com.designpattern.assignment3;

public abstract class Cricket {
	abstract void intializeGameType();

	abstract void startGame();

	abstract void getGameDetails();

	abstract void endGame();

	public final void start() {

		intializeGameType();

		startGame();

		getGameDetails();

		endGame();

	}
}

/**
 * @author Girdhari
 * ActionableMenuItem class will handle all the menu item which takes some actions
 */

package com.metacube.menu;

public class ActionableMenuItem implements MenuItem {
	
		Action action;
		String displayText;

		ActionableMenuItem(String displayText, Action action) {
			this.displayText = displayText;
			this.action = action;
		}

		@Override
		public void display() {
			System.out.println(displayText);

		}

		@Override
		public void takeAction() {
			action.perform();
			return;
		}

	}




/**
 * @author Girdhari
 * This class will contain all the Menu related information display method will print menu
 */

package socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	List<MenuItem> menuItems = new ArrayList<MenuItem>();

	public void addMenuItem(MenuItem item) {
		menuItems.add(item);
	}

	public void display() {
		try {
			for (MenuItem obj : menuItems) {
				obj.display();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

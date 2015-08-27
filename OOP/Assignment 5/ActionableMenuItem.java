/**
 * @author Girdhari
 * Program to create social network
 * ActionableMenuItem class implements MenuItem interface and override display method to print message
 */
package socialnetwork;

public class ActionableMenuItem implements MenuItem{
	String textToDisplay; 
	Action actionObject ;
	ActionableMenuItem(String displayText) {
		this.textToDisplay = displayText;
	}
	@Override
	public void display() {
		System.out.println(textToDisplay);
		
	}
}

/**
 * @author Girdhari
 * Main Class for Logger System
 */
package loggenerater;

/* Starting of Main class */
public class Main {

	/* Starting of main method */
	public static void main(String args[]) {
		/**
		 * @param num1 for first number
		 * @param num2 for second number
		 */
		LoggerClass loggerClass = LoggerClass.getInstance();
		int num1 = 9;
		int num2 = 0;
		action(num1, num2);
		System.out.println("Executed Successfully");
	}
	/* Ending of main method */


	/* Starting of action method */
	public static Integer action(Integer numanator, Integer denominator) {
		Integer output = 0;
		try {
			output = numanator / denominator;
		} catch (ArithmeticException ae) {
			LoggerClass.logException(ae);
		}
		return output;
	}
	/* Ending of action method */

}

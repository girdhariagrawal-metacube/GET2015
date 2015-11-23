/**
 * MainClass 
 * @author Girdhari
 */
package com.designpattern.assignment3;
public class MainClass {
	public static void main(String args[]){
		Cricket cricket = new TwentyTwenty();//setting 20-20 class object in cricket reference
		cricket.start();
		cricket = new OneDayInternational();//setting one day international class object in cricket reference
		cricket.start();
		cricket = new TestCricket();//setting test cricket class object in cricket reference
		cricket.start();
	}
}

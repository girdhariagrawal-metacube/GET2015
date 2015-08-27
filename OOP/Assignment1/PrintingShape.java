/***
 * @author Girdhari
 * Program to illustrate interfaces using shape example 
 * here Shape is an interface and rest( circle, square, printing) are classes 
 */

package interfaceShape;

public class Printing {
	
	public static void main(String []args){
		Square squareObj = new Square(10);
		Circlec circleObj = new Circlec(10);
 		System.out.println("Area of Square is "+squareObj.getArea());
 		System.out.println("Area of Circle is "+circleObj.getArea());
		
	}

}

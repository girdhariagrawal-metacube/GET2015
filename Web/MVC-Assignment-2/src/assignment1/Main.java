/**
* @author Girdhari
* Main class for Assigment 2.1
*/

package assignment1;

public class Main {

	 public static void main(String[] args) throws Exception
	 {
		 // Calling the Function
	      AnnotationParser parser = new AnnotationParser();
	      parser.parse(Employee.class);
	   }
}

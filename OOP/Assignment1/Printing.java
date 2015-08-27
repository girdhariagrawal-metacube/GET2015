package matrix;

public class Printing {
	/*Start of main function*/
	public static void main(String []args){
		Matrix mat = new Matrix(3,2);
		mat.addElements(0, 0, 1);
		mat.addElements(0, 1, 2);
		mat.addElements(1, 0, 4);
		mat.addElements(1, 1, 5);
		mat.addElements(2, 0, 7);
		mat.addElements(2, 1, 8);
		mat.transpose().show();
		
	}
	/*End of main function*/
}

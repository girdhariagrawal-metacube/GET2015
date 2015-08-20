/***
 * 
* @author Girdhari
 * Program to implement Matrix class that contains addElement, transpose, show methods
 * Main Matrix class
 */
package matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixMainClass {
	static int rows = 0, cols = 0;
	public static void main(String []args){
		System.out.print("Enter total Number of rows & columns: ");
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			rows = Integer.parseInt(bufferReader.readLine());
			cols = Integer.parseInt(bufferReader.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("Not A valid number");
			e.printStackTrace();
		}
		
		Matrix matrixObject = new Matrix(rows, cols);
		MatrixGetData matrixGetDataObject = new MatrixGetData();
		MatrixTranspose matrixTransposeObject = new MatrixTranspose();
		MatrixMainClass selfObject = new MatrixMainClass();
		MatrixAddElement matrixAddElementObject = new MatrixAddElement();
		matrixAddElementObject.addElements(matrixObject, 0, 0, 1);
		matrixAddElementObject.addElements(matrixObject, 0, 1, 2);
		matrixAddElementObject.addElements(matrixObject, 1, 0, 3);
		matrixAddElementObject.addElements(matrixObject, 1, 1, 4);
		matrixGetDataObject.show(matrixObject);
		matrixObject = matrixTransposeObject.transpose(matrixObject, selfObject);
		matrixGetDataObject.show(matrixObject);
	}

}

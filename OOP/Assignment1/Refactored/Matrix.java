/***
 * 
* @author Girdhari
 * Program to implement Matrix class that contains addElement, transpose, show methods
 * Master Matrix class
 */

package matrix;

/*Start of Matrix class*/
public class Matrix {
	int data[][];
	int noRows;
	int noCols;
	
	/* Start of Matrix class constructor */
	public Matrix(int row, int col){
		this.noRows = row;
		this.noCols = col;
		data = new int[row][col];
	}
	/* End of Matrix class constructor */
public Matrix(){
		
	}
}
/*End of Matrix class*/

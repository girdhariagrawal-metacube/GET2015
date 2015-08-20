/***
 * 
* @author Girdhari
 * Program to implement Matrix class that contains addElement, transpose, show methods
 * Add Element Class
 */
package matrix;

/*Start of MatrixAddElement class*/
public class MatrixAddElement{
	/* Start of addElement function */
	public boolean addElements(Matrix matrixObject, int row, int col, int val){
		if(row < 0 || col <0) 
			return false;
		else if (row >= matrixObject.noRows || col >= matrixObject.noCols)
			return false;
		else
			matrixObject.data[row][col] = val;
			return true;
	}
	/* End of addElement function */
	
}
/*End of MatrixAddElement class*/

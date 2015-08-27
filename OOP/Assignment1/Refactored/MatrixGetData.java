/***
 * 
* @author Girdhari
 * Program to implement Matrix class that contains addElement, transpose, show methods
 * Get Matrix Data class
 */
package matrix;

/*Start of MatrixGetData class*/
public class MatrixGetData {
	/*starting of getter*/
	public int[][] getData(Matrix matrixObject){
		return matrixObject.data;
	}
	/*end of getter*/

/*Start of show function*/
	public void show(Matrix matrixObject){		//this will print the matrix using the current object
		for(int row = 0 ; row < matrixObject.noRows ; row++){
			for(int col = 0 ; col < matrixObject.noCols ; col++){
				System.out.print(matrixObject.data[row][col]+" ");
			}
			System.out.println();
		}
		
	}
	/*End of show function*/
}
/*End of MatrixGetData class*/

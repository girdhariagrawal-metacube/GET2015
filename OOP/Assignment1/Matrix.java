/***
 * 
* @author Girdhari
 * Program to implement Matrix class that contains addElement, transpose, show methods
 * 
 */

package matrix;

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
	
	/* Start of addElement function */
	public void addElements(int row, int col, int val){
		data[row][col] = val;
	}
	/* End of addElement function */
	
	public Matrix(){
		
	}
	/* Starting of transpose function */
	public Matrix transpose(){		//It will create a object of class Matrix then will transpose
		
		Matrix newObj = new Matrix(noCols, noRows);
		for(int counterRow = 0; counterRow < noRows ; counterRow++){
			for(int counterCol = 0; counterCol < noCols ; counterCol++){
					newObj.data[counterCol][counterRow] = data[counterRow][counterCol];
			}
		}
		return newObj;
	}
	/*End of transpose function*/
	
	/*Start of show function*/
	public void show(){		//this will print the matrix using the current object
		for(int row = 0 ; row < this.noRows ; row++){
			for(int col = 0 ; col < this.noCols ; col++){
				System.out.print(this.data[row][col]+" ");
			}
			System.out.println();
		}
		
	}
	/*End of show function*/
}

/***
 * 
* @author Girdhari
 * Program to implement Matrix class that contains addElement, transpose, show methods
 * Matrix Transpose class
 */
package matrix;

/*Start of Matrix Transpose Class*/
public class MatrixTranspose {
	
	/* Starting of transpose function */
	public Matrix transpose(Matrix matrixObject, MatrixMainClass matrixMainClassObject){		//It will create a object of class Matrix then will transpose
		
		Matrix newObj = new Matrix(matrixObject.noCols, matrixObject.noRows);
		for(int counterRow = 0; counterRow < matrixObject.noRows ; counterRow++){
			for(int counterCol = 0; counterCol < matrixObject.noCols ; counterCol++){
					newObj.data[counterCol][counterRow] = matrixObject.data[counterRow][counterCol];
			}
		}
		return newObj;
	}
	/*End of transpose function*/
}
/*End of Matrix Transpose Class*/

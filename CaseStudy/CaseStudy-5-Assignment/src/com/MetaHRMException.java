/**
 * @author Girdhari
 * User Defined Exception MetaHRMException 
 */

package com;
/* Starting of MetaHRMException */
public class MetaHRMException extends Exception {


	private static final long serialVersionUID = 1L;

	public MetaHRMException(String message) {
		super(message);
	}

	public MetaHRMException(String message, Throwable cause) {
		super(message, cause);
	}

}
/* Ending of MetaHRMException */

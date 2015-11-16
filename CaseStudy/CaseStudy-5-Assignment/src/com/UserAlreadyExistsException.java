/**
 * @author Girdhari
 * User defined exceptin for UserAlreadyExistsException
 */

package com;

/* Starting of UserAlreadyExistsExeption */
public class UserAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException(String message) {
		super(message);
	}

	public UserAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
/* Ending of UserAlreadyExistsExeption */
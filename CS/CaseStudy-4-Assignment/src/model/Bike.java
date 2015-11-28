/**
 * @author Girdhari
 * Bike class have all the Bike related properties and methods which are specific to a bike
 * This class extends Vehicle class
 */
package model;

import lombok.Data;

/* Starting of Bike class */
@Data
public class Bike extends Vehicle {
	private boolean isSelfStart;
	private int helmetPrice;
}
/* Ending of Bike class */
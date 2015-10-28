/**
 * @author Girdhari
 * Car class have all the car related properties and methods which are specific to a car
 * This class extends Vehicle class
 */
package model;

import lombok.Data;

/* Start of Car class */
@Data
public class Car extends Vehicle {

	private boolean hasAC;
	
	private boolean hasPowerSteering;
	
	private boolean hasAccesoriesKit;
	
}
/* End of Car class */
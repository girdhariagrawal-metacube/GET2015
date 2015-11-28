/**
 * @author Girdhari
 * Vehicle class have all the vehicle related properties and methods
 */
package model;

import java.util.Date;

import lombok.Data;


/* Starting of Vehicle Class */
@Data
public abstract class Vehicle {

	private int vehicleId;
	
	private int make;
	
	private String model;
	
	private int engineInCC;
	
	private double fuelCapacity;
	
	private double milage;
	
	private double price;
	
	private double roadTax;

	private String createdBy;
	
	private Date createdTime = new Date();
	
	private TypeVehicle vehicleType;
	
	public double calculateOnRoadPrice() {
		return (price * roadTax) + price; 
	}

	
}
/* End of Vehicle Class */

/*Vehicle - make, model, engineInCC, fuelCapacity, milage, price, roadTax
Create calculateOnRoadPrice method to be overwritten by children*/
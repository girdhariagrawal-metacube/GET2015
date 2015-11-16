/**
 * @author Girdhari
 * BaseModel class for basic and common details
 */

package com.model;

import java.util.Date;
import lombok.Data;

@Data
public class BaseModel {
	
	private int id;
	
	private String createdBy;

	private Date createdTime = new Date();

}

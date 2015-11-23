/**
 * LeaveApprover Class 
 * @author Girdhari
 */

package com.designpattern.assignment2;
public abstract class LeaveApprover {

	protected LeaveApprover approver;
	//sets the approver ffor the leave 
	public void setApprover(LeaveApprover approver){
		this.approver=approver;
	}
	//abstract method 
	public abstract void processLeaveProcessor(int leaveDaysCount);
}

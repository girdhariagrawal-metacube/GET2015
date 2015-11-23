/**
 * LeaveProcessor class  
 * @author Girdhari
 */
package com.designpattern.assignment2;

public class LeaveProcessor {
	public static void main(String args[]){
		LeaveApprover mentor = new Mentor();
		LeaveApprover seniorMentor = new SeniorMentor();
		LeaveApprover hrManager = new HRManager();
		mentor.setApprover(seniorMentor);
		seniorMentor.setApprover(hrManager);
		mentor.processLeaveProcessor(10);
	}
}

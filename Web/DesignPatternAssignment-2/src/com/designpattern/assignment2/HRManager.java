/**
 * HRManager Class
 * @author Girdhari
 */

package com.designpattern.assignment2;
public class HRManager extends Mentor {
	@Override
	public void processLeaveProcessor(int leaveDaysCount) {
		if (leaveDaysCount > 2 && leaveDaysCount <= 5) { //if no of days for leave is less than 5 and greater than two then approve
			System.out.println();
			System.out.println("Leave Approved for" + " " + leaveDaysCount
					+ " days by HR Manager");
		}

		else {//leave can't be approved 
			System.out.println();
			System.out
					.println("Leave Cant be approved Please Meet with the director along with the application and reason for such a long leave");
		}
	}
}

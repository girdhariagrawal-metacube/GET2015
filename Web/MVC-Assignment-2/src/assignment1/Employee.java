package assignment1;

public class Employee {

	@RequestForEnhancement(id = 1, synopsis = "Girdhari")
	public static void employeeDetail(int id, String synopsis, String engineer,String date)
	{
		System.out.println("\nid:"+ id + "\nSynopsis:" + synopsis + "\nEngineer" + engineer
				+ "\nDate" + date);
	}
	
	@RequestForEnhancement(id = 1, synopsis = "Girdhari", engineer = "Engineer", date = "10/17/2015")
	public static void employeeDetails(int id, String synopsis,
			String engineer, String date) {
		System.out.println("\nid:"+ id + "\nSynopsis:" + synopsis + "\nEngineer" + engineer
				+ "\nDate" + date);
	}

	public static void employeeDetail() {
		System.out.println("Not Annotation");
	}
}

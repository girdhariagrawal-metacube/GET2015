package inheritencePtoS;

public class Access {
	public static void main(String[] args) {
		Student studentObj = new Student(101, "Girdhari Agrawal", 1001);
		Teacher teacherObj = new Teacher(001, "Reddy Zokovik", 2001);
		System.out.println(teacherObj.getName());
		System.out.println(studentObj.getName());
	}

}

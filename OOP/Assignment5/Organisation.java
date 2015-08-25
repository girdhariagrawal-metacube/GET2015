package socialnetwork;

import java.util.List;

public class Organisation extends Entity {
	
	private String domain;
	private List<String> courses;
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	

}

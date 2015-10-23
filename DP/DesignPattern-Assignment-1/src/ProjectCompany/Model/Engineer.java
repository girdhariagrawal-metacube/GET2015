/**
 * @author Girdhari
 * abstract class Engineer
 */

package ProjectCompany.Model ;

/* Starting of Engineer class */
public abstract class Engineer {

	private String name;
	private EngineerType role;

	/* protected parameterized class constructor */ 
	protected Engineer(String name, EngineerType role) {
		this.name = name;
		this.role = role;
	}

	/* protected class constructor */
	protected  Engineer() {
	}
	
	/* getters , setters */
	public String getName() {
		return name;
	}

	public EngineerType getRole() {
		return role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(EngineerType role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Name : " + name + ", " + "Role: " + role;
	}
}
/* Ending of Engineer class */
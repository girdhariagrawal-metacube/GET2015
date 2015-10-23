/**
 * @author Girdhari
 * Company class
 */
package ProjectCompany.Model;
import java.util.ArrayList;
import java.util.List;

/* Starting of Company class */
public class Company {

	private static Company company;
	private static List<Engineer> listOfEnginners = new ArrayList<Engineer>();

	/* class Constructor */
	private Company() {
	}
	
	/* Starting of getInstance method */
	public static Company getInstance() {
		if (company == null) {
			synchronized (Company.class) {
				if (company == null)
					company = new Company();
			}
		}
		return company;
	}
	/* Ending of getInstance method */

	/* Starting of addEngineer function */
	public void addEngineer(Engineer engineer) {
		listOfEnginners.add(engineer);
	}
	/* Ending of addEngineer function */

	/* Starting of getListOfEngineers function */
	public static List<Engineer> getListOfEngineers() {
		return listOfEnginners;
	}
	/* Ending of getListOfEngineers function */

}
/* Ending of Company class */
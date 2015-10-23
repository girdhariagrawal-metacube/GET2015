/**
 * @author Girdhari
 * Class DeveloperFactory
 */
package ProjectCompany.Factory;

import ProjectCompany.Model.Developer;
import ProjectCompany.Model.Engineer;
import ProjectCompany.Model.EngineerType;

/* Starting of DeveloperFactory class */
public class DeveloperFactory extends Developer implements EngineerFactory{
	
	private static DeveloperFactory developerFactory;
	
	/* class Constructor */
	private DeveloperFactory() {
	}
	
	/* parameterized class Constructor */
	private DeveloperFactory(String name , EngineerType type) {
		super(name , type);
	}

	/* overridden method createEngineerFactory */
	@Override
	public Engineer createEngineerFactory(String name, EngineerType type) {
		return new DeveloperFactory(name, type);
	}
	
	/* Starting of getInstance method */
	public static DeveloperFactory getInstance() {

		if (developerFactory == null) {
			synchronized (DeveloperFactory.class) {
				if (developerFactory == null)
					developerFactory = new DeveloperFactory();
			}
		}
		return developerFactory;
	}
	/* Ending of getInstance method */
	

}
/* Ending of DeveloperFactory class */
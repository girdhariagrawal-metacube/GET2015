/**
 * @author Girdhari
 * TesterFactory class
 */

package ProjectCompany.Factory;

import ProjectCompany.Model.Engineer;
import ProjectCompany.Model.EngineerType;
import ProjectCompany.Model.Tester;

/* Starting of TesterFactory class */
public class TesterFactory extends Tester implements EngineerFactory {

	private static TesterFactory testerFactory;

	/* class Constructor */
	private TesterFactory() {
	}

	/* parameterized class constructor */
	private TesterFactory(String name, EngineerType type) {
		super(name, type);
	}

	/* overridden method createEngineerFactory */
	@Override
	public Engineer createEngineerFactory(String name, EngineerType type) {
		return new TesterFactory(name, type);
	}

	/* Starting of getInstance method */
	public static TesterFactory getInstance() {

		if (testerFactory == null) {
			synchronized (TesterFactory.class) {
				if (testerFactory == null)
					testerFactory = new TesterFactory();
			}
		}
		return testerFactory;
	}
	/* Ending of getInstance method */

}
/* Ending of TesterFactory class */
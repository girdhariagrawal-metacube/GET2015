/**
 * @author Girdhari
 * EngineerFactory interface 
 */
package ProjectCompany.Factory;

import ProjectCompany.Model.Engineer;
import ProjectCompany.Model.EngineerType;

/* Starting of EngineerFactory interface */
public interface EngineerFactory {
	
	public Engineer  createEngineerFactory(String name ,EngineerType type);
}
/* Ending of EngineerFactory interface */
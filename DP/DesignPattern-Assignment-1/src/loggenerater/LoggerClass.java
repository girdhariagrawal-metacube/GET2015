/**
 * @author Girdhari
 * LoggerClass to implement a logging system
 */

package loggenerater;
import org.apache.log4j.Logger;

/* Starting of LoggerClass class */
public class LoggerClass {

	private final static Logger log = Logger.getLogger(LoggerClass.class.getName());
	private static LoggerClass loggerClass;
	
	private LoggerClass() {
		
	}
	/* Starting of getInstance method */
	public static LoggerClass getInstance() {

		if (loggerClass == null) {
			synchronized (LoggerClass.class) {
				if (loggerClass == null)
					loggerClass = new LoggerClass();
			}
		}
		return loggerClass;
	}
	/* Ending of getInstance method */

	public static void logException(Exception e) {
		try {
			log.error("Exception occurred at " + e.getMessage());
		} catch (Exception exception) {
			System.out.println("Exception Logged");

		}
	}
}
/* Ending of LoggerClass */
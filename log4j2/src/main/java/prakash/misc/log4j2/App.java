package prakash.misc.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author prakash 
 * 09/08/2018 Log manager
 *
 */
public class App {

	private static final Logger logger = LogManager.getLogger("App.class");

	public static void main(String[] args) {
		System.out.println("sop main asf");
		String paswswd = "asf2354@#%ASF";
		String ssn = "123-45-1232";
		String abc = "abc";
		logger.debug("password: {}", paswswd);
		logger.debug("abc: " + abc);
		logger.debug("ssn: {}", ssn);
	}
}

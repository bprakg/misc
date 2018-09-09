package prakash.misc.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author prakash 09/08/2018 Log manager
 *
 */
public class App {

	private static final Logger logger = LogManager.getLogger("App.class");

	public static void main(String[] args) {
		System.out.println("sop main");
		String paswswd = "abc";
		logger.debug("password: {}", paswswd);
	}
}

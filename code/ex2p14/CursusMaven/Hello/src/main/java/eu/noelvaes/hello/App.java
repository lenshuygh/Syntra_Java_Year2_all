package eu.noelvaes.hello;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**My own application class.
 *
 * @author Lens Huygh
 *
 */

public class App {
	private static Logger logger = LogManager.getLogger();
	/**This method says hello to the world.
	 * @return "Hello World"
	 */

	public String sayHello(){
		logger.debug("Somebody called sayHello()");
		return "Hello World";
	}

	public static void main(String[] args){
		App app = new App();
		System.out.println(app.sayHello());
	}
}

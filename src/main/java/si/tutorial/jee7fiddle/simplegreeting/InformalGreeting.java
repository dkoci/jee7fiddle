package si.tutorial.jee7fiddle.simplegreeting;

import javax.enterprise.context.Dependent;

@Dependent
@Informal
public class InformalGreeting extends Greeting {

	public String greet(String name) {
		
		return "Hi " + name + "!";
	}
}

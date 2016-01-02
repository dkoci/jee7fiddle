package si.tutorial.jee7fiddle.producerji.random;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

@RequestScoped
public class Generator {

	java.util.Random random = new java.util.Random(System.currentTimeMillis());
	private final int maxNumber = 100;
	
	@Produces
	@Random
	int next() {
		
		return random.nextInt(maxNumber + 1);
	}
}
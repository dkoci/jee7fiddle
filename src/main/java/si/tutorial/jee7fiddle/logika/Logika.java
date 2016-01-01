package si.tutorial.jee7fiddle.logika;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Logika {

	public List<String> getNames() {
		
		List<String> names = new ArrayList<>();
		names.add("Davorin");
		names.add("Ana");
		names.add("Eva");
		
		return names;
	}
}
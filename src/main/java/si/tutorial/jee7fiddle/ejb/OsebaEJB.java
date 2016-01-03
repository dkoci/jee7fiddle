package si.tutorial.jee7fiddle.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import si.tutorial.jee7fiddle.entity.Oseba;

@Stateless
public class OsebaEJB {

	@PersistenceContext(unitName="jee7fiddlePU")
	private EntityManager em;
	
	public void createOseba() {
		
		Oseba oseba = new Oseba();
		oseba.setImeosebe("Davorin");
		oseba.setEmailosebe("dadi@test.si");
		
		em.persist(oseba);
	}
	
	public void izpisiOsebe() {
		
		TypedQuery query = em.createNamedQuery("Oseba.findAll", Oseba.class);
		List<Oseba> osebaList = query.getResultList();
		
		osebaList.forEach(o -> System.out.println(o.getImeosebe()));
	}
}
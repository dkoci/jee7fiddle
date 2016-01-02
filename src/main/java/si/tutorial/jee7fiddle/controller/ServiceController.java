package si.tutorial.jee7fiddle.controller;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import si.tutorial.jee7fiddle.logika.Logika;
import si.tutorial.jee7fiddle.producerji.random.Random;
import si.tutorial.jee7fiddle.producermethods.Avto;
import si.tutorial.jee7fiddle.producermethods.Chosen;
import si.tutorial.jee7fiddle.producermethods.IVozilo;
import si.tutorial.jee7fiddle.producermethods.Motor;
import si.tutorial.jee7fiddle.simplegreeting.Greeting;
import si.tutorial.jee7fiddle.simplegreeting.Informal;
import si.tutorial.jee7fiddle.v1.helloservice.HelloService;
import si.tutorial.jee7fiddle.v1.helloservice.IHelloService;

@Model
public class ServiceController {

	@Inject
	private Logika logika;

	// si.tutorial.jee7fiddle.simplegreeting
	@Inject
	@Informal // ce to zakomentiramo, potem se poklice uradna verzija pozdrava
	Greeting greeting;

	// si.tutorial.jee7fiddle.producerji.random
	@Inject
	@Random
	private int randomInt;

	// si.tutorial.jee7fiddle.producermethods
	private final static int TIP = 1; // 1 = avto, 2 = motor

	@Produces
	@Chosen
	public IVozilo getVozilo() {

		switch (TIP) {
		case 1:
			return new Avto();

		case 2:
			return new Motor();

		default:
			return null;
		}
	}
	
	@Inject
	@Chosen
	@RequestScoped
	IVozilo vozilo;

	public void doGetNames() {

		logika.getNames().forEach(ime -> System.out.println(ime));

		System.out.println("------------Klic vmesnika------------");

		HelloService helloService = new HelloService();
		IHelloService port = helloService.getHelloServicePort();

		System.out.println(port.sayHello("Davorin"));

		System.out.println("------------si.tutorial.jee7fiddle.simplegreeting------------");

		System.out.println(greeting.greet("Davorin"));
		System.out.println();

		System.out.println("------------si.tutorial.jee7fiddle.producerji.random------------");

		System.out.println("Random integer: " + randomInt);
		System.out.println();
		
		System.out.println("------------si.tutorial.jee7fiddle.producesmethods------------");
		
		System.out.println("Izbrali smo: " + vozilo.getTipVozila());
		System.out.println();
		
	}
}
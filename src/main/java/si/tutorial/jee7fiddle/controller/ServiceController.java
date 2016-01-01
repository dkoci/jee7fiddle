package si.tutorial.jee7fiddle.controller;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import si.tutorial.jee7fiddle.logika.Logika;
import si.tutorial.jee7fiddle.v1.helloservice.HelloService;
import si.tutorial.jee7fiddle.v1.helloservice.IHelloService;

@Model
public class ServiceController {
	
	@Inject
	private Logika logika;
	
	public void doGetNames() {
		
		logika.getNames().forEach(ime -> System.out.println(ime));
		
		System.out.println("------------Klic vmesnika------------");
		
		HelloService helloService = new HelloService();
		IHelloService port = helloService.getHelloServicePort();
		
		System.out.println(port.sayHello("Davorin"));
	}
}

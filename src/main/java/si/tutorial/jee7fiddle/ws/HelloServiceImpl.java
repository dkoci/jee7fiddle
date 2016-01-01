package si.tutorial.jee7fiddle.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName="HelloService",
			targetNamespace="http://tutorial.si/jee7fiddle/v1/HelloService/",
			portName="HelloServicePort",
			name="IHelloService")
public class HelloServiceImpl {

	@WebMethod(operationName="sayHello")
	public String sayHello(@WebParam(name="name") String name) {
		
		return "Hello " + name;
	}
}

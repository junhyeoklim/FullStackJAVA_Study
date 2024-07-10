package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		TV tv = factory.getBean("samsungTV", SamsungTV.class);

		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();	
		
		factory.close();
	}
}
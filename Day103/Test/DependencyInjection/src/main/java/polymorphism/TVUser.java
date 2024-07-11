package polymorphism;

import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		/*
		 * AbstractApplicationContext factory = new
		 * GenericXmlApplicationContext("applicationContext.xml");
		 * 
		 * TV tv = (TV)factory.getBean("tv"); tv.powerOn(); tv.powerOff();
		 * tv.volumeUp(); tv.volumeDown();
		 * 
		 * factory.close();
		 */
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean collectionBean = (CollectionBean) ctx.getBean("collectionBean");
		Set<String> addressList = collectionBean.getAddressList();
		
		for(String address:addressList )
			System.out.println(address);
		
	}
}
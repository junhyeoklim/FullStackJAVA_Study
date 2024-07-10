package come.superman.ex;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		CollectionBean collectionBean = factory.getBean("collectionBean", CollectionBean.class);
		List<String> addressList = collectionBean.getAddressList();
		for(String str: addressList)
			System.out.println(str);
		factory.close();
	}

}

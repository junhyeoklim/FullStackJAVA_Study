package com.superman.ex;

import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		CollectionBean collectionBean = ctx.getBean("collectionBean", CollectionBean.class);
		Set<String> addressList = collectionBean.getAddressList();
		for(String address:addressList)
			System.out.println(address);

	}

}

package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		String configLoc = "classpath:applicationContext.xml";
		AbstractApplicationContext factory = new GenericXmlApplicationContext(configLoc);
		MyInfo myInfo = (MyInfo) factory.getBean("myInfo");
		myInfo.getInfo();
		factory.close();
	}
}
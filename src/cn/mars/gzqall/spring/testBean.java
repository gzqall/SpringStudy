package cn.mars.gzqall.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testBean {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext( "applicationContext.xml");
		
		baseBean bb = (baseBean) ac.getBean( "baseBean" );
		bb.printValue();
	}
}

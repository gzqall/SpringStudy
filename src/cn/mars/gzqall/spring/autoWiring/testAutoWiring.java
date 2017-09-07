package cn.mars.gzqall.spring.autoWiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class  testAutoWiring{


	public static void main(String[] args) {
		//ÔÚapplicationContextÖÐµÄ bean
//		ApplicationContext ac = new ClassPathXmlApplicationContext( "applicationContext.xml");
//		
//		BaseBean bb = (BaseBean) ac.getBean( "baseBean" );
//		bb.printValue();

		ApplicationContext ac = new ClassPathXmlApplicationContext( new String[] {"autoWiringContext.xml"});
		
		Customer ct = (Customer) ac.getBean( "customer" );
		System.out.println( ct.toString() );
	}
}

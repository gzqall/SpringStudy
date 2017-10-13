package cn.mars.gzqall.spring.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class printCollect {
	public static void main( String[] args ) {
		ApplicationContext context = new ClassPathXmlApplicationContext( new String[]{"collectionTestContext.xml"} );
		collectionTest ct = (collectionTest) context.getBean( "collectionInit" );
		System.out.println(	ct.toString() );
	}
}

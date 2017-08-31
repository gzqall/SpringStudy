package cn.mars.gzqall.spring.dataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomJdbcTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext( "applicationContext.xml" );
		
		CustomDbInter dbi = (CustomDbInter) ac.getBean( "customeDb" );
		
		CustomBean cb = new CustomBean( "高志强", "北京市海淀区", 201, 18 );
		
		dbi.insertOneCustom( cb );
		
		CustomBean cc = dbi.findOneCustom( 201 );
		
		System.out.println( cc.toString() );
	}
}

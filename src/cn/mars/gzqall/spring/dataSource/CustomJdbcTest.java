package cn.mars.gzqall.spring.dataSource;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomJdbcTest {
	public static void main(String[] args) {
		//读取applicationContext中的Bean
		ApplicationContext ac = new ClassPathXmlApplicationContext( "applicationContext.xml" );
		
		//获取 customDb Bean 在 SpringJdbc中的 gzq_customDb.xml中，由 applicationContext.xml 中 import
		//获取的是 CustomDbInter接口类型
		//CustomDbInter dbi = (CustomDbInter) ac.getBean( "CustomDbInter" ); //使用 基础 jdbc开发
		CustomDbInter dbi = (CustomDbInter) ac.getBean( "customJdbcTempDb" ); //使用 jdbcTemplate 进行jdbc的开发
		
		//CustomBean cb = new CustomBean( "高志强", "北京市昌平区", 204, 18 );
		
		//dbi.insertOneCustom( cb );
		
	//	CustomBean cc = dbi.findOneCustom( 201 );
		
	//System.out.println(	cc.toString() );
		List<CustomBean> ll = dbi.findCustomList( "高志强", 18 );
		Iterator<CustomBean> it = ll.iterator();
		while( it.hasNext() )
			System.out.println( it.next().toString() );
		
	}
}

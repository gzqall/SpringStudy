package cn.mars.gzqall.spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class scopeCallMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"scopeTestContext.xml"});
		//默认 单例bean 两次调用同一对象
		scopeTest st = (scopeTest) context.getBean( "scopeService" );
		st.setMessage( "gaozqall" );
		System.out.println( st.getMessage() );
		
		scopeTest st1 = (scopeTest) context.getBean( "scopeService" );
		System.out.println( st1.getMessage() );
		
		//prototype bean 两次调用不同对象
		scopeTest sst = (scopeTest) context.getBean( "scopeService1" );
		sst.setMessage( "gaozqall" );
		System.out.println( sst.getMessage() );
		
		scopeTest sst1 = (scopeTest) context.getBean( "scopeService1" );
		System.out.println( sst1.getMessage() );
	}
}

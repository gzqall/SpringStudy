package cn.mars.gzqall.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {

	public static void main(String[] args) {
		//ÔÚapplicationContextÖÐµÄ bean
//		ApplicationContext ac = new ClassPathXmlApplicationContext( "applicationContext.xml");
//		
//		BaseBean bb = (BaseBean) ac.getBean( "baseBean" );
//		bb.printValue();

		ApplicationContext ac = new ClassPathXmlApplicationContext( new String[] {"gzqSpringContext.xml"});
		
		BeanImplTest bit = (BeanImplTest) ac.getBean( "getBeanImpl" );
		bit.execBeanInger();
	}
}

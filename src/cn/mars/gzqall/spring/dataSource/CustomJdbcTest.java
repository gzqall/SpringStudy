package cn.mars.gzqall.spring.dataSource;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomJdbcTest {
	public static void main(String[] args) {
		//��ȡapplicationContext�е�Bean
		ApplicationContext ac = new ClassPathXmlApplicationContext( "applicationContext.xml" );
		
		//��ȡ customDb Bean �� SpringJdbc�е� gzq_customDb.xml�У��� applicationContext.xml �� import
		//��ȡ���� CustomDbInter�ӿ�����
		//CustomDbInter dbi = (CustomDbInter) ac.getBean( "CustomDbInter" ); //ʹ�� ���� jdbc����
		CustomDbInter dbi = (CustomDbInter) ac.getBean( "customJdbcTempDb" ); //ʹ�� jdbcTemplate ����jdbc�Ŀ���
		
		//CustomBean cb = new CustomBean( "��־ǿ", "�����в�ƽ��", 204, 18 );
		
		//dbi.insertOneCustom( cb );
		
	//	CustomBean cc = dbi.findOneCustom( 201 );
		
	//System.out.println(	cc.toString() );
		List<CustomBean> ll = dbi.findCustomList( "��־ǿ", 18 );
		Iterator<CustomBean> it = ll.iterator();
		while( it.hasNext() )
			System.out.println( it.next().toString() );
		
	}
}

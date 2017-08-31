package cn.mars.gzqall.spring.dataSource.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.mars.gzqall.spring.dataSource.CustomBean;
import cn.mars.gzqall.spring.dataSource.CustomDbInter;

//ʹ�� Spring jdbcTemplate ���JDBC�Ĳ��� �򻯴���
// JdbcTemplate ��װ�� ���ݿ�� ��ɾ�Ĳ�Ȳ���
public class CustomJdbcTempImpl implements CustomDbInter {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource( DataSource da ) {
		dataSource = da;
	}
	
	private void initTemp() {
		if( jdbcTemplate != null )
			return;
		if( dataSource != null )
			jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertOneCustom(CustomBean cb) {
		String insertSql = new String( "INSERT INTO CUSTOM( CUSTID, NAME, AGE, ADDR ) VALUES ( ?, ?, ?, ? )" );
		initTemp();
		//ʹ�� jdbcTmepleate ֱ��ʹ�� update���� ��SQL �Լ� SQL�еĲ�������object������ʽ����˳��ֵ
		int ii = jdbcTemplate.update( insertSql, new Object[] { cb.getCustId(), cb.getName(), cb.getAge(), cb.getAddr()} );
		System.out.println( "insert into custom num is " + ii );
	}

	@Override
	public CustomBean findOneCustom(int custId) {
		String querySql = new String( "SELECT CUSTID, NAME, AGE, ADDR FROM CUSTOM WHERE CUSTID = ?" );
		initTemp();
		
		//jdbcTemplate ��������ѯʹ�� ���ǽ����������Bean�����Ե�ӳ�� ��Ҫʵ��RowMapper �ӿ� ���� �ֹ���ӳ��
		//CustomRowMapper ʵ���� RowMapper ��ResultSet�е����� ��CustomBean�е� ���˶�Ӧ��ӳ��
		CustomBean cb = (CustomBean) jdbcTemplate.queryForObject( querySql, new Object[] { custId },  new CustomRowMapper() );

		//������ʹ�� Spring 2.5 �Ժ� �Դ���BeanPropertyRowMapper �� �������ResultSet �������� CustomBean��������ȥƥ�� ��CUSTID'���»��ߡ�CUST_ID��
		//CustomBean ccb = (CustomBean) jdbcTemplate.queryForObject( querySql, new Object[] { custId }, new BeanPropertyRowMapper(CustomBean.class) );
		return cb;
	}

	@Override
	public List<CustomBean> findCustomList( String custName, int age) {
		String querySql = new String( "SELECT CUSTID, NAME, AGE, ADDR FROM CUSTOM WHERE NAME = ? AND AGE = ?" );
		initTemp();

		List<CustomBean> customList = new ArrayList<CustomBean>();
		//jdbcTemplate ������Ϊ���¼��ѯ��queryForList ����һ�� List �ڲ�Ϊ���ݿ��ֶε�Key �� Value��Map
		//���Ҫ��ȡ��Ӧ��Bean ���� ����Ҫ �ֶ��Ľ����ݽ���ӳ��
		//jdbcTemplate.queryForXXX XXX�Ƿ�������
		List<Map<String, Object>> resultRows =  jdbcTemplate.queryForList( querySql, new Object[]{"��־ǿ", 18});
		
		for( Map<String, Object> mm : resultRows ) {
			CustomBean cb = new CustomBean();
			cb.setAddr( (String) mm.get("ADDR"));
			cb.setCustId( (int) mm.get("CUSTID"));
			cb.setAge( (int) mm.get("AGE"));
			cb.setName( (String) mm.get("NAME"));
			
			customList.add( cb );
		}
		//Spring2.5�Ժ�� BeanPropertyRowMapper ���԰������Զ�ӳ�� ����ô ��ѯ������Ҫ�� Bean�������� �ſ��Զ���ӳ��
		//customList = jdbcTemplate.query(querySql, new Object[]{ "��־ǿ", 18 }, new BeanPropertyRowMapper<CustomBean>(CustomBean.class));

		return customList;
	}
}

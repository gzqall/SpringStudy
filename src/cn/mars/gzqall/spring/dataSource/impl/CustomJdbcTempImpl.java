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

//使用 Spring jdbcTemplate 完成JDBC的操作 简化代码
// JdbcTemplate 封装了 数据库的 增删改查等操作
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
		//使用 jdbcTmepleate 直接使用 update方法 将SQL 以及 SQL中的参数，以object数据形式，按顺序赋值
		int ii = jdbcTemplate.update( insertSql, new Object[] { cb.getCustId(), cb.getName(), cb.getAge(), cb.getAddr()} );
		System.out.println( "insert into custom num is " + ii );
	}

	@Override
	public CustomBean findOneCustom(int custId) {
		String querySql = new String( "SELECT CUSTID, NAME, AGE, ADDR FROM CUSTOM WHERE CUSTID = ?" );
		initTemp();
		
		//jdbcTemplate 可以做查询使用 但是结果集与最终Bean中属性的映射 需要实现RowMapper 接口 进行 手工的映射
		//CustomRowMapper 实现了 RowMapper 将ResultSet中的数据 与CustomBean中的 做了对应的映射
		CustomBean cb = (CustomBean) jdbcTemplate.queryForObject( querySql, new Object[] { custId },  new CustomRowMapper() );

		//还可以使用 Spring 2.5 以后 自带的BeanPropertyRowMapper 类 该类根据ResultSet 的列名与 CustomBean的属性名去匹配 ”CUSTID'或下划线“CUST_ID”
		//CustomBean ccb = (CustomBean) jdbcTemplate.queryForObject( querySql, new Object[] { custId }, new BeanPropertyRowMapper(CustomBean.class) );
		return cb;
	}

	@Override
	public List<CustomBean> findCustomList( String custName, int age) {
		String querySql = new String( "SELECT CUSTID, NAME, AGE, ADDR FROM CUSTOM WHERE NAME = ? AND AGE = ?" );
		initTemp();

		List<CustomBean> customList = new ArrayList<CustomBean>();
		//jdbcTemplate 可是作为多记录查询，queryForList 返回一个 List 内部为数据库字段的Key 与 Value的Map
		//如果要获取对应的Bean 数据 则需要 手动的将数据进行映射
		//jdbcTemplate.queryForXXX XXX是返回类型
		List<Map<String, Object>> resultRows =  jdbcTemplate.queryForList( querySql, new Object[]{"高志强", 18});
		
		for( Map<String, Object> mm : resultRows ) {
			CustomBean cb = new CustomBean();
			cb.setAddr( (String) mm.get("ADDR"));
			cb.setCustId( (int) mm.get("CUSTID"));
			cb.setAge( (int) mm.get("AGE"));
			cb.setName( (String) mm.get("NAME"));
			
			customList.add( cb );
		}
		//Spring2.5以后的 BeanPropertyRowMapper 可以帮助做自动映射 ，那么 查询的列名要与 Bean属性相似 才可自动做映射
		//customList = jdbcTemplate.query(querySql, new Object[]{ "高志强", 18 }, new BeanPropertyRowMapper<CustomBean>(CustomBean.class));

		return customList;
	}
}

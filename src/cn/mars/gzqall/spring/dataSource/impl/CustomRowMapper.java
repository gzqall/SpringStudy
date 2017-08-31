package cn.mars.gzqall.spring.dataSource.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cn.mars.gzqall.spring.dataSource.CustomBean;

public class CustomRowMapper implements RowMapper<Object>{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomBean cb = new CustomBean();
		cb.setCustId( rs.getInt( "CUSTID" ) );
		cb.setAge( rs.getInt( "AGE" ) );
		cb.setName( rs.getString( "NAME" ) );
		cb.setAddr( rs.getString( "ADDR" ) );

		return cb;
	}

}

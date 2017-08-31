package cn.mars.gzqall.spring.dataSource.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import cn.mars.gzqall.spring.dataSource.CustomBean;
import cn.mars.gzqall.spring.dataSource.CustomDbInter;

public class CustomDbImpl implements CustomDbInter {
	private DataSource dataSource;
	private Connection conn = null;
	private PreparedStatement ps = null;
	
	public void setDataSource( DataSource ds ){
		this.dataSource = ds;
	}

	public void initConn() throws SQLException {
		if( dataSource != null )
			conn = dataSource.getConnection();
	}
	
	public void initPreState( String sql ) throws SQLException {
		if( conn != null )
			ps = conn.prepareStatement( sql );
	}
	
	public void close() throws SQLException {
		if( ps != null )
			ps.close();
		if( conn != null )
			conn.close();
	}
	@Override
	public void insertOneCustom(CustomBean cb) {
		String insertSql = new String( "INSERT INTO CUSTOM( CUSTID, NAME, AGE, ADDR ) VALUES ( ?, ?, ?, ? )" );
		
		try{
			initConn();
			initPreState( insertSql );
			
			ps.setInt( 1, cb.getCustId() );
			ps.setString(2, cb.getName() );
			ps.setInt(3, cb.getAge() );
			ps.setString(4, cb.getAddr() );
			ps.execute();

		} catch(SQLException sse){
			System.out.println( sse );
		}finally{
			try{
			close();
			} catch(SQLException sqle) {
				
			}
		}
	}

	@Override
	public CustomBean findOneCustom(int custId) {
		String querySql = new String( "SELECT CUSTID, NAME, AGE, ADDR FROM CUSTOM WHERE CUSTID = ?" );
		
		ResultSet rs = null;
		CustomBean cb = null;
		try{
			initConn();
			initPreState( querySql );
			
			ps.setInt( 1, custId );
			rs = ps.executeQuery();
			while( rs.next() ){
				cb = new CustomBean();
				cb.setCustId( rs.getInt( "CUSTID" ) );
				cb.setName( rs.getString( "NAME" ) );
				cb.setAge( rs.getInt( "AGE" ) );
				cb.setAddr( rs.getString( "ADDR" ) );
			}
		} catch(SQLException sse){
			System.out.println( sse );
		}finally{
			try{
				if( rs != null )
					rs.close();
				close();
			} catch(SQLException sqle) {
				
			}
		}
		return cb;
	}

	@Override
	public List<CustomBean> findCustomList( String custName, int age) {
		String querySql = new String( "SELECT CUSTID, NAME, AGE, ADDR FROM CUSTOM WHERE NAME = ? and age = ?" );
		
		List<CustomBean> customList = new ArrayList<CustomBean>();
		ResultSet rs = null;
		try{
			initConn();
			initPreState( querySql );
			
			ps.setInt( 2, age );
			ps.setString( 1, custName );
			rs = ps.executeQuery();
			while( rs.next() ){
				CustomBean cb = new CustomBean();
				cb.setCustId( rs.getInt( "CUSTID" ) );
				cb.setName( rs.getString( "NAME" ) );
				cb.setAge( rs.getInt( "AGE" ) );
				cb.setAddr( rs.getString( "ADDR" ) );
				customList.add( cb );
			}
		} catch(SQLException sse){
			System.out.println( sse );
		}finally{
			try{
				if( rs != null )
					rs.close();
				close();
			} catch(SQLException sqle) {
				
			}
		}
		return customList;
	}
}

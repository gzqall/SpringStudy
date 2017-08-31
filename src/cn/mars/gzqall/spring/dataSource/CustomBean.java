package cn.mars.gzqall.spring.dataSource;

public class CustomBean {
	private String name;
	private String addr;
	private int custId;
	private int age;
	
	public CustomBean( ) {
	}
	
	public CustomBean( String name, String addr, int custId, int age ) {
		this.name = name;
		this.addr = addr;
		this.custId = custId;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer( "This Custom name is " );

		sb.append( name );
		sb.append( ", age is " );
		sb.append( String.valueOf( age ) );
		sb.append( " addr is " );
		sb.append( addr );
		sb.append( " cust id is " );
		sb.append( String.valueOf( custId) );

		return sb.toString();
	}
	
}

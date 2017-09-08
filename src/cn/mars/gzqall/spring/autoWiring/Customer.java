package cn.mars.gzqall.spring.autoWiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Customer {
	//Autowired 注解到成员变量上
	//自动装配 如果 Spring 未找到 对应类型的自动装配对象，则会报错。
	//使用 @Autowired(required=false) 设置 不检查 则就不会报Exception
	//@Qualifier 如果自动装配中 同类型的Bean 有很多 但是本类中也能标识出是那个类，则使用该注解来指定 对应的bean 的id
	@Autowired(required=false)
	@Qualifier( "persion" )
	private Person persion;
	private String cust_id;
	private int cust_level;

	public Customer( Person person, String custId, int custLevel ){
		this.persion = person;
		this.cust_id = custId;
		this.cust_level = custLevel;
	}
	//使用Autowired 标注 构造方法 则会通过构造方法 自动装配
	
	//@Autowired
	public Customer( Person person ){
		System.out.println( "xxxxxxxxxxxxxx" );
		this.persion = person;
	}

	public Customer() {}

	public Person getPersion() {
		return persion;
	}

	//可以使用 AUtowired 注解 来标注 set方法、成员变量 构造方法等来完成自动装配
	//@Autowired
	public void setPersion(Person persion) {
		System.out.println( "yyyyyyyyyyyyyyy" );
		this.persion = persion;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public int getCust_level() {
		return cust_level;
	}

	public void setCust_level(int cust_level) {
		this.cust_level = cust_level;
	}

	@Override
	public String toString() {
		if( this.persion == null )
			return "persion is null ";
		else
		return "Customer [persion=" + persion.toString() + ", cust_id=" + cust_id
				+ ", cust_level=" + cust_level + "]";
	}

}

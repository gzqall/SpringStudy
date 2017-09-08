package cn.mars.gzqall.spring.autoWiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Customer {
	//Autowired ע�⵽��Ա������
	//�Զ�װ�� ��� Spring δ�ҵ� ��Ӧ���͵��Զ�װ�������ᱨ��
	//ʹ�� @Autowired(required=false) ���� ����� ��Ͳ��ᱨException
	//@Qualifier ����Զ�װ���� ͬ���͵�Bean �кܶ� ���Ǳ�����Ҳ�ܱ�ʶ�����Ǹ��࣬��ʹ�ø�ע����ָ�� ��Ӧ��bean ��id
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
	//ʹ��Autowired ��ע ���췽�� ���ͨ�����췽�� �Զ�װ��
	
	//@Autowired
	public Customer( Person person ){
		System.out.println( "xxxxxxxxxxxxxx" );
		this.persion = person;
	}

	public Customer() {}

	public Person getPersion() {
		return persion;
	}

	//����ʹ�� AUtowired ע�� ����ע set��������Ա���� ���췽����������Զ�װ��
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

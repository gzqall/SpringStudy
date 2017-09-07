package cn.mars.gzqall.spring.autoWiring;

public class Customer {
	private Person persion;
	private String cust_id;
	private int cust_level;

	public Customer( Person person, String custId, int custLevel ){
		this.persion = person;
		this.cust_id = custId;
		this.cust_level = custLevel;
	}
	public Customer( Person person ){
		System.out.println( "xxxxxxxxxxxxxx" );
		this.persion = person;
	}

	public Customer() {}
	public Person getPersion() {
		return persion;
	}

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
		return "Customer [persion=" + persion.toString() + ", cust_id=" + cust_id
				+ ", cust_level=" + cust_level + "]";
	}

}

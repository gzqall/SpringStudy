package cn.mars.gzqall.spring.autoWiring;

public class Person {
	
	private String name;
	private int age;
	private String addr;
	private String id_no;

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", addr=" + addr
				+ ", id_no=" + id_no + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getId_no() {
		return id_no;
	}
	public void setId_no(String id_no) {
		this.id_no = id_no;
	}
	
	
}

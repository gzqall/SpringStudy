package cn.mars.gzqall.spring;

import cn.mars.gzqall.spring.interFaceColl.GetBeanInter;

public class BeanImplTest {
	private GetBeanInter gbi;

//bean 中的 set 与 get方法 必须 是 get成员变量名 set成员变量名 否则 Spring不认 报错 
//如 setBeanInter  就会报错 	
	public void setgbi( GetBeanInter gb ) {
		this.gbi = gb;
	}
	
	public  GetBeanInter getgbi( ) {
		return this.gbi;
	}
	
	public void execBeanInger() {
		gbi.printBeanInfo();
	}
}


package cn.mars.gzqall.spring;

import cn.mars.gzqall.spring.interFaceColl.GetBeanInter;

public class BeanImplTest {
	private GetBeanInter gbi;

//bean �е� set �� get���� ���� �� get��Ա������ set��Ա������ ���� Spring���� ���� 
//�� setBeanInter  �ͻᱨ�� 	
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


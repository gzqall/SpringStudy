package cn.mars.gzqall.spring.interFaceColl.interFaceImpl;

import cn.mars.gzqall.spring.interFaceColl.GetBeanInter;

public class GaozqaBeanImpl implements GetBeanInter{

	@Override
	public void printBeanInfo() {
		System.out.println( "this is gaozqa bean info !!!");
	}

}

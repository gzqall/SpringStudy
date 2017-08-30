package cn.mars.gzqall.spring.interFaceColl.interFaceImpl;

import cn.mars.gzqall.spring.interFaceColl.getBeanInter;

public class gzqallBeanImpl implements getBeanInter{

	@Override
	public void printBeanInfo() {
		System.out.println( "this is gzqall bean!!!" );
	}

}

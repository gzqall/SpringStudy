package cn.mars.gzqall.spring.dataSource;

import java.util.List;
public interface CustomDbInter {
	public void insertOneCustom( CustomBean cb );
	public CustomBean findOneCustom(  int custId );
	public List<CustomBean> findCustomList(   String custName, int age );
}

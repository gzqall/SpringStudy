package cn.mars.gzqall.spring.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class collectionTest {
	private List< Object > list = null;
	private Set< Object > set = null;
	private Map< Object, Object > map = null;
	private Properties pros = null;
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public Set<Object> getSet() {
		return set;
	}
	public void setSet(Set<Object> set) {
		this.set = set;
	}
	public Map<Object, Object> getMap() {
		return map;
	}
	public void setMap(Map<Object, Object> map) {
		this.map = map;
	}
	public Properties getPros() {
		return pros;
	}
	public void setPros(Properties pros) {
		this.pros = pros;
	}
	
	public String toString(){
		return list.toString()+"\n"+set.toString()+"\n"+map.toString()+"\n"+pros.toString();
		
	}
}

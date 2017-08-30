package cn.mars.gzqall.spring;

public class BaseBean {
	private String valueName;
	
	public void setValueName( String ss ) {
		valueName = ss;
	}
	public String getValueName(  ) {
		if( valueName != null && valueName.length() > 0 )
				return valueName ;
		else
			return "value name is empty string" ;
	}
	
	public void printValue( ) {
		System.out.println( getValueName() );
	}
}

package org.dorosh.spring.ch4;



public interface SimpleBeanInterface {
	
	static final String DEFAULT_NAME="Luke SkyWalker";

	public void setName(String name);
	public void setAge(int age);
	public void afterPropertiesSet();
	
}

package org.dorosh.spring.ch4.Interface;

import org.dorosh.spring.ch4.SimpleBeanInterface;
import org.springframework.beans.factory.InitializingBean;

public class SimpleBeanWithInterface implements SimpleBeanInterface, InitializingBean {

	private String name;
	private int age=Integer.MIN_VALUE;

	@Override
	public void setName(String name){
		this.name=name;
	}

	@Override
	public void setAge(int age){
		this.age=age;
	}

	@Override
	public void afterPropertiesSet(){
		System.out.println("Initializing Bean in "+SimpleBeanWithInterface.class);
		if(name==null) {
			System.out.println("Using default name");
			name=DEFAULT_NAME;
		}

		if(age==Integer.MIN_VALUE){
			throw new IllegalArgumentException("You must set the age property of any beans of type"+
				SimpleBeanWithInterface.class);
		}
		

	}

	public String toString(){
		return "Name: "+name+ "\nAge: "+age;
	}
   
}

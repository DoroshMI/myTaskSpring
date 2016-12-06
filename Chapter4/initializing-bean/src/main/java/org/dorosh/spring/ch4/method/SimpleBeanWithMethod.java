package org.dorosh.spring.ch4.method;

import org.dorosh.spring.ch4.SimpleBeanInterface;

public class SimpleBeanWithMethod implements SimpleBeanInterface {

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
		System.out.println("Initializing Bean in "+SimpleBeanWithMethod.class);
		if(name==null) {
			System.out.println("Using default name");
			name=DEFAULT_NAME;
		}

		if(age==Integer.MIN_VALUE){
			throw new IllegalArgumentException("You must set the age property of any beans of type"+
				SimpleBeanWithMethod.class);
		}
		

	}

	public String toString(){
		return "Name: "+name+ "\nAge: "+age;
	}
   
}

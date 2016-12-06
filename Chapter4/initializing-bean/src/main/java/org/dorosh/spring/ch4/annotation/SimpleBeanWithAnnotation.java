package org.dorosh.spring.ch4.annotation;

import org.dorosh.spring.ch4.SimpleBeanInterface;
import javax.annotation.PostConstruct;

public class SimpleBeanWithAnnotation implements SimpleBeanInterface {

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
	@PostConstruct
	public void afterPropertiesSet(){
		System.out.println("Initializing Bean in "+SimpleBeanWithAnnotation.class);
		if(name==null) {
			System.out.println("Using default name");
			name=DEFAULT_NAME;
		}

		if(age==Integer.MIN_VALUE){
			throw new IllegalArgumentException("You must set the age property of any beans of type"+
				SimpleBeanWithAnnotation.class);
		}
		

	}

	public String toString(){
		return "Name: "+name+ "\nAge: "+age;
	}
   
}

package org.dorosh.spring;

public class HelloWorldMessageProvider implements MessageProvider{
	@Override
	public String getMessage(){
		return "HelloWorld";
	}
}
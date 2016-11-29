package org.dorosh.spring.ch2;

public class HelloWorldMessageProvider implements MessageProvider{
	@Override
	public String getMessage(){
		return "HelloWorld";
	}
}
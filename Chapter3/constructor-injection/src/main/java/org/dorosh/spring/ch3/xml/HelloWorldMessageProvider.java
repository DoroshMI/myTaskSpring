package org.dorosh.spring.ch3.xml;

import org.dorosh.spring.ch3.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {
	private String message;

	public HelloWorldMessageProvider(){
		
	}
	public HelloWorldMessageProvider(String message){
		this.message=message;
	}

	public HelloWorldMessageProvider(String message, Integer i){
		this.message=message+i;
	}

	public void setMessage(String message){
		this.message=message;
	}
    @Override
    public String getMessage() {
        return message;
    }
}

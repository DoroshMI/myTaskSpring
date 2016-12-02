package org.dorosh.spring.ch3.annotation;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.dorosh.spring.ch3.MessageProvider;

@Service("provider")
public class HelloWorldMessageProvider implements MessageProvider {

	@Autowired @Qualifier("messageNew1")
	private String message;

	
	public HelloWorldMessageProvider(){
		
	}

	//@Autowired @Qualifier("messageNew1")
	public HelloWorldMessageProvider(String message){
		this.message=message;
	}

	
    @Override
    public String getMessage() {
        return message;
    }
}

package org.dorosh.spring.ch3.annotation;

import org.springframework.stereotype.Service;
import org.dorosh.spring.ch3.MessageProvider;

@Service("provider")
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World! Annotation!!!!";
    }
}

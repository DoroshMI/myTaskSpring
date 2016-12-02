package org.dorosh.spring.ch3.xml;

import org.dorosh.spring.ch3.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}

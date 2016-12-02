package org.dorosh.spring.ch3.annotation;

import org.springframework.stereotype.Service;
import org.dorosh.spring.ch3.MessageRenderer;
import org.dorosh.spring.ch3.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;

@Service("renderer")
public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    @Autowired
    public StandardOutMessageRenderer(MessageProvider messageProvider){
        //System.out.println("New Construct")
        this.messageProvider=messageProvider;
    }
    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
            "You must set the property messageProvider of class:"
            + StandardOutMessageRenderer.class.getName());
        }

        System.out.println(messageProvider.getMessage());
    }

    @Override
    
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}

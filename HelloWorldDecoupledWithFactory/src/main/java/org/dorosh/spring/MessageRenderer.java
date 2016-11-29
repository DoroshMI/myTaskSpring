package org.dorosh.spring;

public interface MessageRenderer{
	void render();
	void setMessageProvider(MessageProvider provider);
	MessageProvider getMessageProvider();
}
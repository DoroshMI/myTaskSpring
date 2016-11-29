package org.dorosh.spring;

public class HelloWorldDecoupledWithFactory{
	public static void main(String...args){
		MessageRenderer renderer=MessageSupportFactory.getInstance().getMessageRenderer();
		MessageProvider provider=MessageSupportFactory.getInstance().getMessageProvider();
		//renderer.setMessageProvider(provider);
		renderer.render();
	}
}
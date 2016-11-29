package org.dorosh.spring.ch2;

public class StandartOutMessageRenderer implements MessageRenderer{
	private MessageProvider messageProvider;

	@Override
	public void render(){
		if(messageProvider==null){
			throw new RuntimeException("You must set the property messageProvider of class"+
				StandartOutMessageRenderer.class.getName());
		}
		System.out.println(messageProvider.getMessage());
	}

	@Override
	public void setMessageProvider(MessageProvider messageProvider){
		this.messageProvider=messageProvider;
	}

	@Override
	public MessageProvider getMessageProvider (){
		return messageProvider;
	}


} 
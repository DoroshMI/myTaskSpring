package org.dorosh.spring.ch5;

import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

class SecurityAdvice implements MethodBeforeAdvice{
	private SecurityManager securityManager;

	public SecurityAdvice(){
		this.securityManager=new SecurityManager();
	}

	@Override
	public void before(Method method, Object[] args, Object target){
		UserInfo user=securityManager.getLoggedOnUser();
		if (user.getUserName()==null) {
			System.out.println("No user authenticated");
			throw new SecurityException("You must login before ....");
		} else if ("chris".equals(user.getUserName())) {
			System.out.println("Logged in user is chris - OK");
		} else {
			System.out.println("Logged in user is " + user.getUserName() + "NOT GOOD : (");
			throw new SecurityException("User " + user.getUserName()+ 
				" is not allowed access to method " + method.getName());
		}
	}
}
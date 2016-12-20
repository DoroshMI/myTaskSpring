package org.dorosh.spring.ch5;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample{
	public static void main(String ... args){
		SecurityManager manager = new SecurityManager();
		SecurityBean bean = getSecurityBean();

		manager.login("chris", "pwd");
		bean.writeSecureMessage();

		try {
            manager.login("invaliduser", "pwd");
            bean.writeSecureMessage();
        } catch(SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        } finally {
            manager.logout();
        }

        try {
            bean.writeSecureMessage();
        } catch(SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        }
	}

	private static SecurityBean getSecurityBean(){
		SecurityBean target = new SecurityBean();

		SecurityAdvice advice =new SecurityAdvice();

		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(advice);
		pf.setTarget(target);

		SecurityBean proxy = (SecurityBean) pf.getProxy();
		return proxy;

	}
}
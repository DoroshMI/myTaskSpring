package org.dorosh.spring.ch4;

import org.dorosh.spring.ch4.method.SimpleBeanWithMethod;
import org.dorosh.spring.ch4.Interface.SimpleBeanWithInterface;
import org.dorosh.spring.ch4.annotation.SimpleBeanWithAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InitializingBean {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        //ctx.load("classpath:META-INF/spring/app-context-method.xml");
        //ctx.load("classpath:META-INF/spring/app-context-interface.xml");
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();
        SimpleBeanInterface simpleBean1 = getBean("simpleBean1", ctx);
        SimpleBeanInterface simpleBean2 = getBean("simpleBean2", ctx);
        SimpleBeanInterface simpleBean3 = getBean("simpleBean3", ctx);

    }

    private static SimpleBeanInterface getBean(String beanName, ApplicationContext ctx){
    	try {
    		//SimpleBeanInterface bean = ctx.getBean(beanName, SimpleBeanWithMethod.class);
    		//SimpleBeanInterface bean = ctx.getBean(beanName, SimpleBeanWithInterface.class);
    		SimpleBeanInterface bean = ctx.getBean(beanName, SimpleBeanWithAnnotation.class);
    	 	System.out.println(bean);
    	 	return bean;
    	} catch(BeanCreationException e){
    		System.out.println("An error occered in bean configuration"+
    			e.getMessage());
    		return null;
    	}
        
    }
}

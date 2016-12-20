package org.dorosh.spring.ch4;

import org.dorosh.spring.ch4.method.SimpleBeanWithMethod;
import org.dorosh.spring.ch4.Interface.SimpleBeanWithInterface;
import org.dorosh.spring.ch4.annotation.SimpleBeanWithAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DestroyBean {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        GenericXmlApplicationContext ctxAnnotation = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-method.xml");
        ctx.registerShutdownHook();
        ctx.refresh();
        //ctx.load("classpath:META-INF/spring/app-context-interface.xml");
        
        SimpleBeanInterface bean = ctx.getBean("destractiveBean", SimpleBeanWithMethod.class);
        //SimpleBeanInterface bean = ctx.getBean("destractiveBean", SimpleBeanWithInterface.class);
        //SimpleBeanInterface bean = ctx.getBean("destractiveBean", SimpleBeanWithAnnotation.class);

        System.out.println("Calling destroy()");
        //ctx.destroy();
        System.out.println("Called destroy()");

        //System.out.println("Calling destroy()");
        //ctxAnnotation.destroy();
        //System.out.println("Called destroy()");
        
    }
}

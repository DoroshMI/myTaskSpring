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
        //ctx.load("classpath:META-INF/spring/app-context-method.xml");
        //ctx.load("classpath:META-INF/spring/app-context-interface.xml");
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();
        //SimpleBeanInterface bean = ctx.getBean("destractiveBean", SimpleBeanWithMethod.class);
        //SimpleBeanInterface bean = ctx.getBean("destractiveBean", SimpleBeanWithInterface.class);
        SimpleBeanInterface bean = ctx.getBean("destractiveBean", SimpleBeanWithAnnotation.class);

        System.out.println("Calling destroy()");
        ctx.destroy();
        System.out.println("Called destroy()");
        
    }
}

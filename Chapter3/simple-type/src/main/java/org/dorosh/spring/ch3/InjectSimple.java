package org.dorosh.spring.ch3;

import org.dorosh.spring.ch3.xml.SimpleValue;
//import org.dorosh.spring.ch3.annotation.SimpleValue;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimple {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        //ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        SimpleValue simple = ctx.getBean("injectPropsSimpleValue", SimpleValue.class);

        System.out.println(simple);
    }
}

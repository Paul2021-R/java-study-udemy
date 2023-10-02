package com.in28minutes.learnspringframework.examples.h1;

import com.in28minutes.learnspringframework.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XmlConfigurationContextLauncherApplication {

    public static void main(String[] argv) {
       try( var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")){
           // TODO: do something
           Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
           System.out.println("Print Bean NAME : " + context.getBean("name").toString());
           System.out.println("Print Bean Age : " + context.getBean("age"));
           System.out.println("Print Bean Game Running : ");
           context.getBean(GameRunner.class).run();
       }

    }
}

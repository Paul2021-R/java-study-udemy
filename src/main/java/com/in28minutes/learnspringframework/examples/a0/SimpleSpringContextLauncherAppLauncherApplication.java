package com.in28minutes.learnspringframework.examples.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
//@ComponentScan("com.in28minutes.learnspringframework.examples.a1")
@ComponentScan // 현재폴더를 그대로 쓸 거라면 그냥 작성 안하면 된다.
public class SimpleSpringContextLauncherAppLauncherApplication {

    public static void main(String[] argv) {
       try( var context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncherAppLauncherApplication.class)){
           // TODO: do something
           Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
       }

    }
}

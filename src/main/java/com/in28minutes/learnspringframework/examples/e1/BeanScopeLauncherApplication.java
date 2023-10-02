package com.in28minutes.learnspringframework.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class NormalClass {

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {

}

@Configuration
@ComponentScan
public class BeanScopeLauncherApplication {

    public static void main(String[] argv) {
       try( var context = new AnnotationConfigApplicationContext(BeanScopeLauncherApplication.class)){
           // TODO: do something
           System.out.println(context.getBean(NormalClass.class));
           System.out.println(context.getBean(NormalClass.class));

           System.out.println(context.getBean(PrototypeClass.class));
           System.out.println(context.getBean(PrototypeClass.class));
           System.out.println(context.getBean(PrototypeClass.class));
       }

    }
}

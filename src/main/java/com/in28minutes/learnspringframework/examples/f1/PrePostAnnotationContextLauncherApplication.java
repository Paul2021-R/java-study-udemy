package com.in28minutes.learnspringframework.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private SomeDependency someDependency;
    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All Dependencies are ready!");
    }

    @PostConstruct
    public void initialize() {
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println("Dependency is removed!?");
    }
}

@Component
class SomeDependency {
    public void getReady() {
        System.out.println("Some logic using SomeDependency!");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApplication {

    public static void main(String[] argv) {
       try( var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class)){
           // TODO: do something
           Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

       }

    }
}

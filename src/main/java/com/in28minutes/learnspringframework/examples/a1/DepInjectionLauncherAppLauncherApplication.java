package com.in28minutes.learnspringframework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class  YourBusinessClass {
//    @Autowired// Spring이 관리할 수 있도록 만듬.
    Dependency1 dependency1;
//    @Autowired
    Dependency2 dependency2;

//    @Autowired 필수 아님...!!
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor Injection - YourBusinessClass");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    //    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        System.out.println("Setter Injection - set Dependency1");
//        this.dependency1 = dependency1;
//    }
//
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        System.out.println("Setter Injection - set Dependency2");
//        this.dependency2 = dependency2;
//    }

    public String toString() {
        return "Using " + dependency1 + " and " + dependency2;
    }

}

@Component
class Dependency1 {}

@Component
class Dependency2 {

}

@Configuration
//@ComponentScan("com.in28minutes.learnspringframework.examples.a1")
@ComponentScan // 현재폴더를 그대로 쓸 거라면 그냥 작성 안하면 된다.
// 결론적으로 현재 ComponentScan, Configuration 설정 덕분에 의존성을 위한 클래스 객체들이 모두 검사가 된다.
public class DepInjectionLauncherAppLauncherApplication {

    public static void main(String[] argv) {
       try( var context = new AnnotationConfigApplicationContext(DepInjectionLauncherAppLauncherApplication.class)){
           // TODO: do something
           Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
           System.out.println(context.getBean(YourBusinessClass.class).toString());
       }

    }
}

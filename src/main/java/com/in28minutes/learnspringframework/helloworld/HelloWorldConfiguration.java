package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// record Released in JDK 16
record Person (String name, int age, Address address) { };
record Address (String firstLine, String city) {};
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Ranga";
    }

    @Bean
    public int age() {
        return 15;
    }

    @Bean
    @Primary
    public Person person() {
        var person = new Person("Ravi", 20, new Address("Main Street", "Utrecht"));
        return person;
    }

    @Bean
    public Person person2MethodCall() {
        var person = new Person(this.name(), this.age(), this.address());
        return person;
    }

    @Bean
    public Person person3Parameter(String name, int age, Address address3) {
        var person = new Person(name, age, address3);
        return person;
    }

    @Bean
    public Person person4Parameter(String name, int age, Address address3) {
        var person = new Person(name, age, address3);
        return person;
    }

    @Bean(name = "address2")
    @Primary
    public Address address(){
        var address = new Address("Boncheon-Dong", "Seoul");
        return address;
    }

    @Bean(name = "address3")
    @Qualifier("address3Qualifier")
    public Address address3(){
        var address = new Address("Sinrim-Dong", "Seoul");
        return address;
    }

}

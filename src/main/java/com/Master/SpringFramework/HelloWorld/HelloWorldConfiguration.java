package com.Master.SpringFramework.HelloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Person(String name, int age,Address address) {};

record Address(String firstLine , String city) {};
@Configuration
public class HelloWorldConfiguration {

	@Bean
	public String name() {
		
		return "Urvashi";
	}
	
	@Bean
	public int age() {
		return 24;
	}
	
	@Bean
	public String firstLine() {
		return "Malad";
	}
	@Bean
	public String city() {
		return "Pune";
	}
	@Bean
	public Person person() {
		return new Person("urvashi1", 20,new Address("Borivali","Mumbai"));
	 
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(),address());
	 
	}
	
	@Bean
	public Person person3Parameters(String name,int age,Address address3) {
		return new Person(name, age,address3);
	 
	}
	@Bean
	@Primary
	public Person person4Parameters(String name,int age,Address address) {
		return new Person(name, age,address);
	 
	}
	@Bean
	public Person person5Qualifier(String name,int age,@Qualifier("address3qualifier") Address address) {
		return new Person(name, age,address);
	 
	}
	
	@Bean(name="address2")
	@Primary
	public Address address() {
		return new Address("Borivali","Mumbai");
		
		
	}
	@Bean(name="address3")
	@Qualifier("address3qualifier")
	public Address address3() {
		return new Address("Airoli","NaviMumbai");
		
		
	}
}

package com.Master.SpringFramework;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Person(String name, int age) {};

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
		return new Person("urvashi1", 20);
	 
	}
	
	@Bean
	public Address address() {
		return new Address("Borivali","Mumbai");
		
		
	}
}

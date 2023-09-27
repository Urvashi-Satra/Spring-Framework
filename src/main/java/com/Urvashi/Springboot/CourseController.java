package com.Urvashi.Springboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
 
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses(){
		return Arrays.asList(
				new Course(1,"AWS","A-Author"),
				new Course(2,"java","B-Author"),
				new Course(3,"SQL","C-Author")
				
				);
	}
}

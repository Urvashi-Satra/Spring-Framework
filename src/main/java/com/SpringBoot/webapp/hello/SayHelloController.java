package com.SpringBoot.webapp.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SayHelloController {

	/**
	 * say-hello => "Hello"
	 */
	@RequestMapping("say-hello")
	public String sayHello() {
		return "Hello";
	}
	
	@RequestMapping("say-hello-html")
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My first html Page </title>");
		sb.append("<Body> ");
		sb.append("Hello from html");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
	
//	@GetMapping("say-hello-jsp")
//	public String sayHelloJsp() {
//		return "sayHello";
//	}
	
	 @RequestMapping("/say-hello-jsp")
	    public ModelAndView sayHelloJsp() {
	        ModelAndView modelAndView = new ModelAndView("sayHello"); // "sayHello" corresponds to the view name
	        // You can add model attributes if needed
//	        modelAndView.addObject("message", "Hello, World!"); // Example attribute
	        
	        return modelAndView;
	    }
}

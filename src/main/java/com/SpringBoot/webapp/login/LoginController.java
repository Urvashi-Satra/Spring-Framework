package com.SpringBoot.webapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;



@RestController
@SessionAttributes("name")
public class LoginController {
//	@Autowired
//private AuthenticationService authenticationService;
//
//	
//
//
//	private Logger logger = LoggerFactory.getLogger(getClass());
//	 @RequestMapping("/login")
//	    public ModelAndView sayHelloJsp() {
//	        ModelAndView modelAndView = new ModelAndView("login"); // "sayHello" corresponds to the view name     
//	        return modelAndView;
//	    }
//
//	 @RequestMapping("/login")
//	 public ModelAndView gotoLoginPage(@RequestParam String name , ModelMap model) {
//		 System.out.println("name = " +name);
//		 model.put("name", name);
////		 logger.info("Request param is {}",name);
//		 ModelAndView modelAndView = new ModelAndView("login"); // "sayHello" corresponds to the view name     
//        return modelAndView;
//	 }
	
	

	 @RequestMapping(value="/",method = RequestMethod.GET)
	 public ModelAndView gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		 ModelAndView modelAndView = new ModelAndView("welcome"); // "sayHello" corresponds to the view name     
       return modelAndView;
	 }
	 
	 private String getLoggedinUsername() {
	 
	 Authentication authentication=
			 SecurityContextHolder.getContext().getAuthentication();
	 
	 return authentication.getName();
	 }
	 
	 
//
//	 @RequestMapping(value="/login",method = RequestMethod.POST)
//	 public ModelAndView gotoWelcomePage(@RequestParam String name,
//			 							@RequestParam String password,ModelMap map) {
//		
//		 if(authenticationService.authenticate(name, password)) {
//		 map.put("name", name);
//		map.put("password", password);
//		
//		ModelAndView modelAndView = new ModelAndView("welcome"); // "sayHello" corresponds to the view name     
//      
//		
//		return modelAndView;
//		 }
//		 map.put("errorMessage", "Invalid Credentials ! Please try again.");
//		 ModelAndView modelAndView = new ModelAndView("login"); // "sayHello" corresponds to the view name     
//	       return modelAndView;
//	 }
}

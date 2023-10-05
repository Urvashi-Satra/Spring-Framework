package com.SpringBoot.webapp.Todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@RestController
@SessionAttributes("name")
public class TodoControllerJpa {

	@Autowired
	private TodoRepository repository;
//	public TodoControllerJpa(TodoRepository repository) {
//		super();
//		this.todoService = todoService;
//		this.repository=repository;
//	}
//
//	private TodoService todoService;

	@RequestMapping("list-todos")
	public ModelAndView listAllTodos(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<Todo> todos = repository.findByUsername(username);
	//	List<Todo> todos = todoService.findByUsername(username);
		model.addAttribute("todos", todos);
		ModelAndView modelAndView = new ModelAndView("listToDos"); // "sayHello" corresponds to the view name
		return modelAndView;

	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public ModelAndView showNewTodoPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		ModelAndView modelAndView = new ModelAndView("todo"); // "sayHello" corresponds to the view name
		return modelAndView;

	}
//	@RequestMapping(value="add-todo",method = RequestMethod.POST)
//	public ModelAndView addNewTodoPage(@RequestParam String description,ModelMap model) {
//		todoService.addTodo((String)model.get("name"), description, LocalDate.now().plusYears(1), false);
//		 ModelAndView modelAndView = new ModelAndView("redirect:list-todos"); // "sayHello" corresponds to the view name     
//       return modelAndView;
//
//	}



	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public ModelAndView addNewTodoPage(ModelMap model,
			@Valid Todo todo,BindingResult result) {
		
		if(result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("todo"); // "sayHello" corresponds to the view name
			return modelAndView;
		}
		String username=getLoggedInUsername(model);
		todo.setUsername(username);
		repository.save(todo);
//		todoService.addTodo(username, 
//				todo.getDescription(), 
//				todo.getTargetDate(), todo.isDone());
		ModelAndView modelAndView = new ModelAndView("redirect:list-todos"); // "sayHello" corresponds to the view name
		return modelAndView;
		

	}
	
	
	@RequestMapping("delete-todo")
	public ModelAndView deleteTodo(@RequestParam int id) {
		//todoService.deleteById(id);
		repository.deleteById(id);
		ModelAndView modelAndView = new ModelAndView("redirect:list-todos"); // "sayHello" corresponds to the view name
		return modelAndView;

	}
	
	@RequestMapping("update-todo")
	public ModelAndView ShowupdateTodoPage(@RequestParam int id, ModelMap model) {
		
		Todo todo= repository.findById(id).get();
		//Todo todo= todoService.findById(id);
		model.addAttribute("todo",todo);
		
		ModelAndView modelAndView = new ModelAndView("todo"); // "sayHello" corresponds to the view name
		return modelAndView;

	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public ModelAndView updateTodo(ModelMap model,
			@Valid Todo todo,BindingResult result) {
		
		if(result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("todo"); // "sayHello" corresponds to the view name
			return modelAndView;
		}
		String usernameString=getLoggedInUsername(model);
		
		repository.save(todo);
	//	todoService.updateTodo(todo);
		todo.setUsername(usernameString);
		ModelAndView modelAndView = new ModelAndView("redirect:list-todos"); // "sayHello" corresponds to the view name
		return modelAndView;
		

	}
	 private String getLoggedInUsername(ModelMap model) {
		 
		 Authentication authentication=
				 SecurityContextHolder.getContext().getAuthentication();
		 
		 return authentication.getName();
		 }
		

}

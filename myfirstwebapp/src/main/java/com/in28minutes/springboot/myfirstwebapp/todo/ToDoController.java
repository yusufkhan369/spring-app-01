package com.in28minutes.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToDoController {
	
	private ToDoService doService;
	
	public ToDoController(ToDoService doService) {
		super();
		this.doService = doService;
	}

	@RequestMapping("list-todos")
	public String lisAllToDos(ModelMap model) {
		List<ToDo> list = doService.findByUsername("in28minutes");
		model.addAttribute("todos", list);
		return "listTodos";
	}

}

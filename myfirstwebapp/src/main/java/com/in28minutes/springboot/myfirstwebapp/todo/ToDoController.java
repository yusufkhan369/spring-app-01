package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	// GET, POST
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage() {
		return "todo";
	}

	// GET, POST
	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo(@RequestParam String description, ModelMap map) {
		doService.addTodo((String) map.get("name"), description, LocalDate.now().plusDays(1), false);
		return "redirect:list-todos";
	}

}

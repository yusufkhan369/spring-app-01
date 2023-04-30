package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.in28minutes.springboot.myfirstwebapp.todo.ToDo;

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

	//GET, POST
		@RequestMapping(value="add-todo", method = RequestMethod.GET)
		public String showNewTodoPage(ModelMap model) {
			String username = (String)model.get("name");
			ToDo todo = new ToDo(0, username, "Default Desc", LocalDate.now().plusYears(1), false);
			model.put("todo", todo);
			return "todo";
		}


		@RequestMapping(value="add-todo", method = RequestMethod.POST)
		public String addNewTodo(ModelMap model, ToDo todo) {
			String username = (String)model.get("name");
			doService.addTodo(username, todo.getDescription(), 
					LocalDate.now().plusYears(1), false);
			return "redirect:list-todos";
		}
		
		@RequestMapping("delete-todo")
		public String deleteAToDo(@RequestParam int id) {
			doService.deleteById(id);
			
			return "redirect:list-todos";
		}
		
		@RequestMapping("update-todo")
		public String updateAToDo(@RequestParam int id, ModelMap map) {
			ToDo todo = doService.findById(id);
			map.addAttribute("todo", todo);
			return "todo";
		}

}

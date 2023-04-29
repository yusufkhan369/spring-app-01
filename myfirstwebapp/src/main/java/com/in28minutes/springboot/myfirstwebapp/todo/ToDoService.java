package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	
	private static List<ToDo> toDos = new ArrayList<ToDo>();
	
	static {
		toDos.add(new ToDo(1, "in28minutes", "desc", LocalDate.now().plusDays(1), false));
		toDos.add(new ToDo(2, "zam2", "desc2", LocalDate.now().plusDays(2), false));
		toDos.add(new ToDo(3, "zam3", "desc3", LocalDate.now().plusDays(3), false));
	}
	
	public List<ToDo> findByUsername(String username){
		return toDos;
	}

}

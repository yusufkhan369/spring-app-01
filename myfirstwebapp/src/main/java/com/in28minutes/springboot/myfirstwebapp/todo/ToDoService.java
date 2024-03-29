package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {

	private static List<ToDo> toDos = new ArrayList<ToDo>();
	private static int todosCount = 0;

	static {
		toDos.add(new ToDo(++todosCount, "in28minutes", "desc", LocalDate.now().plusDays(1), false));
		toDos.add(new ToDo(++todosCount, "zam2", "desc2", LocalDate.now().plusDays(2), false));
		toDos.add(new ToDo(++todosCount, "zam3", "desc3", LocalDate.now().plusDays(3), false));
	}

	public List<ToDo> findByUsername(String username) {
		return toDos;
	}

	public void addTodo(String username, String description, LocalDate date, boolean done) {
		ToDo toDo = new ToDo(++todosCount, username, description, date, done);
		toDos.add(toDo);
	}
	
	public void deleteById(int id) {
        Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		toDos.removeIf(predicate);
	}

	public void showUpdateToDo(int id) {
		// TODO Auto-generated method stub
		
	}

	public ToDo findById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		return toDos.stream().filter(predicate).findFirst().get();
	}

}

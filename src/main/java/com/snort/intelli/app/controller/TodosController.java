package com.snort.intelli.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snort.intelli.app.Model.Todos;
import com.snort.intelli.app.Repository.TodosRepository;

@RestController
//@RequestMapping("/todos") : in case of common http like todos/delete, todos update, todos findall etc
public class TodosController {
	@Autowired
	TodosRepository todosRepository;

	private Logger log = LoggerFactory.getLogger(TodosController.class);

	@PostMapping("/todos/create")
	public String createTask(@RequestBody Todos todos) {
		log.info("Todos controller : create Task executed");
		return todosRepository.createtask(todos);
	}

	@GetMapping("/todos")
	public List<Todos> findAll() {
		log.info("Todos controller : Findall Task executed");
		return todosRepository.findAll();

	}

	@GetMapping("/todos/{id}")
	public Todos findOneTodo(@PathVariable Long id) {
		log.info("Todos controller : FindOne Task executed");
		Todos todos = todosRepository.findOne(id);
		return todos;
	}

	@DeleteMapping("/todos/delete/{id}")
	public String deleteOneTodo(@PathVariable Long id) {
		log.info("Todos controller : deleteOne Task executed");
		return todosRepository.deleteOne(id);

	}

	@PutMapping("/todos/update/{id}")
	public String updateOneTodos(@PathVariable Long id, @RequestBody Todos newtodos) {
		log.info("Todos controller : update  Task executed");

		return todosRepository.update(id, newtodos);

	}

}

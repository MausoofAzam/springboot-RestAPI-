package com.snort.intelli.app.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.snort.intelli.app.Model.Todos;
@Component
public class TodosRepository {

	// data stored in Database//hard-coded value

	private static List<Todos> todosList;


	public TodosRepository() {
		todosList = new ArrayList<>();
		todosList.add(new Todos(101L,"Create UI page", "create userReginstration", false, new Date(), null));
		todosList.add(new Todos(102L,"Create Database in Oracle", "create userReginstration", false, new Date(), null));
		todosList.add(new Todos(103L,"Create Dao Class", "create DaoClass Impl", false, new Date(), null));
	}

	public List<Todos> findAll() {
		return todosList;
	}

	public Todos findOne(Long id) {
	
		for (Todos todos : todosList) {
			if(todos.getTaskId().equals(id)) {
				return todos ;
			}
		}
		
		return new Todos();
	}

	public String deleteOne(Long id) {
		for (Todos todos : todosList) {
			if(todos.getTaskId().equals(id)) {
				
				todosList.remove(todos);
				return "Todos deleted successfully with id::"+id ;
			}
		}
		
		return "Todos deletion failed id::"+id;
	}


	
	public String createtask( Todos todos) {
		todosList.add(todos);
		return "Sucessfully new task added with Id :"+todos.getTaskId();
	}
	
	public String update(Long id ,Todos newtodos) {
		for (Todos oldtodo : todosList) {
			if (oldtodo.getTaskId().equals(id)) {
				//update when match found
				oldtodo.setTitle(newtodos.getTitle() !=null?newtodos.getTitle():oldtodo.getTitle());
				oldtodo.setDescription(newtodos.getDescription() != null?newtodos.getDescription():oldtodo.getDescription());
				oldtodo.setCompleted(newtodos.getCompleted() !=null?newtodos.getCompleted():oldtodo.getCompleted() );
				oldtodo.setUpdatedDate(new Date());
				
				return "Todos updated for id ::"+id;
			} 
			
		}
		return "Todos failed to Update for id:: "+newtodos.getTaskId();
	}
	
	
	
	
	
	
	
	
	
	
	
}

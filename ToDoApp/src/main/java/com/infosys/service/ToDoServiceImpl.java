package com.infosys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entity.ToDo;
import com.infosys.repository.ToDoRepo;

@Service
public class ToDoServiceImpl implements ToDoService {
	@Autowired
	ToDoRepo repository;

	@Override
	public List<ToDo> getAllToDoItems() {
		ArrayList<ToDo> todoList = new ArrayList<>();
		repository.findAll().forEach(todo -> todoList.add(todo));
		return todoList;
	}

	@Override
	public ToDo getToDoItemById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public boolean updateStatus(Integer id) {
		ToDo toDo = getToDoItemById(id);
		toDo.setStatus("Completed");

		return saveOrUpdateToDoItem(toDo);
	}

	@Override
	public boolean saveOrUpdateToDoItem(ToDo todo) {
		ToDo updatedObj = repository.save(todo);

		if (getToDoItemById(updatedObj.getId()) != null) {
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteToDoItem(Integer id) {
		repository.deleteById(id);

		if (repository.findById(id).isEmpty()) {
			return true;
		}
		return false;
	}

}

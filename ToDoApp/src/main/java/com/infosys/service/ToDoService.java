package com.infosys.service;

import java.util.List;

import com.infosys.entity.ToDo;

public interface ToDoService {
	public List<ToDo> getAllToDoItems();
    public ToDo getToDoItemById(Integer id);
    public boolean updateStatus(Integer id);
    public boolean saveOrUpdateToDoItem(ToDo todo);
    public boolean deleteToDoItem(Integer id);
}

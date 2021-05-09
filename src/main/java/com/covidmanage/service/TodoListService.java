package com.covidmanage.service;

import com.covidmanage.dto.TodoListDTO;
import com.covidmanage.mapper.ext.TodoListMapperExt;
import com.covidmanage.pojo.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoListService {

    @Autowired
    private TodoListMapperExt  todoListMapperExt;

    public void addTodoList(String identityId, String todoThing) {
        todoListMapperExt.addTodoList(identityId, todoThing);
    }

    public List<TodoListDTO> getTodoList(String identityId) {
        List<TodoList> todoList = todoListMapperExt.getTodoList(identityId);
        List<TodoListDTO> todoListDTOS = new ArrayList<>();
        for(TodoList todo : todoList){
            TodoListDTO todoDTO = TodoListDTO.builder()
                    .id(todo.getId())
                    .title(todo.getTodoThing())
                    .status(todo.getIsDeleted() == 1)
                    .build();
            todoListDTOS.add(todoDTO);
        }
        return todoListDTOS;
    }

    public void editTodoListStatus(String identityId, Integer id) {
        TodoList todo = todoListMapperExt.getTodoListByIdAndIdentityId(identityId, id);
        int flag = 0;
        if(todo.getIsDeleted() == 0){
            flag = 1;
        }else if(todo.getIsDeleted() == 1){
            flag = 0;
        }
        todoListMapperExt.editTodoListStatus(identityId, id, flag);
    }
}

package com.covidmanage.controller;

import com.covidmanage.dto.TodoListDTO;
import com.covidmanage.service.TodoListService;
import com.covidmanage.utils.ResponseCode;
import com.covidmanage.utils.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://192.168.0.9:8080", allowCredentials = "true")
@RestController
@RequestMapping("/todo")
public class TodoListController {

    @Autowired
    private TodoListService todoListService;

    @PostMapping("/addTodoList")
    public ResponseTemplate addTodoList(@RequestParam(value = "identityId") String identityId,
                                        @RequestParam(value = "todoThing") String todoThing){
        todoListService.addTodoList(identityId, todoThing);
        return  ResponseTemplate.success(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg());
    }

    @GetMapping("/getTodoList")
    public ResponseTemplate getTodoList(@RequestParam(value = "identityId") String identityId){
        List<TodoListDTO> todoList = todoListService.getTodoList(identityId);
        Map<Object, Object> map = new HashMap<>();
        map.put("todoList", todoList);
        return ResponseTemplate.success(map);
    }

    @PostMapping("/editTodoListStatus")
    public ResponseTemplate editTodoListStatus(@RequestParam(value = "identityId") String identityId,
                                               @RequestParam(value = "id") Integer id){
        todoListService.editTodoListStatus(identityId, id);
        return ResponseTemplate.success(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg());
    }
}

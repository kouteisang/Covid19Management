package com.covidmanage.controller;

import com.covidmanage.dto.TodoListDTO;
import com.covidmanage.service.TodoListService;
import com.covidmanage.utils.ResponseCode;
import com.covidmanage.utils.ResponseTemplate;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://172.20.10.2:8080", allowCredentials = "true")
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

    @PostMapping("/editInfo")
    public ResponseTemplate editInfo(@RequestParam(value = "identityId") String identityId,
                                     @RequestParam(value = "title") String title,
                                     @RequestParam(value = "id") Integer id){
        todoListService.editInfo(identityId, title, id);
        return ResponseTemplate.success(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg());
    }

    @PostMapping("/deleteInfo")
    public ResponseTemplate deleteInfo(@RequestParam(value = "id") Integer id){
        todoListService.deleteInfo(id);
        return ResponseTemplate.success(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg());
    }
}

package com.covidmanage.mapper.ext;

import com.covidmanage.mapper.TodoListMapper;
import com.covidmanage.pojo.TodoList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TodoListMapperExt extends TodoListMapper {

    void addTodoList(@Param("identityId") String identityId,
                @Param("todoThing") String todoThing);

    List<TodoList> getTodoList(@Param("identityId") String identityId);

    TodoList getTodoListByIdAndIdentityId(@Param("identityId") String identityId,
                                          @Param("id") Integer id);

    void editTodoListStatus(@Param("identityId") String identityId, @Param("id") Integer id, @Param("flag") int flag);

}

package com.example.TodoApp.controller;

import com.example.TodoApp.model.Todo;
import com.example.TodoApp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;


    @GetMapping("todos")
    public List<Todo> getAllTodos()
    {
        return todoService.getAllTodos();
    }

    @ResponseBody
    @GetMapping("todo/done")
    public List<Todo> getDoneTodos()
    {
        return todoService.getAllDoneTodos();
    }

    @GetMapping("todos/{todoId}")
    public Todo getTodoById(@PathVariable Integer todoId)
    {
        return todoService.getTodoById(todoId);
    }

    @GetMapping("todo/undone")
    public List<Todo> getNotDoneTodos()
    {
        return todoService.getUndoneTodos();
    }

    @PostMapping("todo")
    public String addTodo(@RequestBody Todo todo)
    {
        return todoService.addTodo(todo);
    }

    @PutMapping("todo/{todoId}/{status}")
    public String markTodo(@PathVariable Integer todoId,@PathVariable boolean status)
    {
        return todoService.updateTodoStatus(todoId,status);
    }

    @DeleteMapping("todo")
    public String removeTodo(@RequestParam Integer todoId)
    {
        return todoService.removeTodo(todoId);

    }
}

package com.todo.controller;

import com.todo.dto.Todo;
import com.todo.service.TodoHardcodedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {

    private final TodoHardcodedService todoService;

    public TodoResource(TodoHardcodedService service) {
        this.todoService = service;
    }

    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        return todoService.findAll();
    }

    @DeleteMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
        Todo todo = todoService.deleteById(id);
        if(todo != null){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}

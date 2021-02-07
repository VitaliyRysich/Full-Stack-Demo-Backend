package com.todo.controller;

import com.todo.dto.Todo;
import com.todo.service.TodoHardcodedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(path = "/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id){
        return todoService.findById(id);
    }

    @DeleteMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
        Todo todo = todoService.deleteById(id);
        if(todo != null){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }


    @PutMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable String username,
            @PathVariable long id,
            @RequestBody Todo todo) {

        Todo todoUpdated = todoService.save(todo);
        return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);
    }

    @PostMapping(path = "/users/{username}/todos")
    public ResponseEntity<Void> createTodo(
            @PathVariable String username,
            @RequestBody Todo todo) {

        Todo todoCreated = todoService.save(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(todoCreated.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}

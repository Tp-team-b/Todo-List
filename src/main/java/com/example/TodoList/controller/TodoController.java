package com.example.TodoList.controller;


import com.example.TodoList.dto.TodoRequest;
import com.example.TodoList.dto.TodoResponse;
import com.example.TodoList.entitiy.Todo;
import com.example.TodoList.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponse> create(TodoRequest request) {
        Todo todo = todoService.create(request);
        return ResponseEntity.ok(new TodoResponse(todo));
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoResponse> findById(@PathVariable Long id) {
        Todo todo = todoService.findById(id);
        return ResponseEntity.ok(new TodoResponse(todo));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> findAll() {
        List<Todo> todoList = todoService.findAll();
        List<TodoResponse> todoResponse = todoList.stream().map(TodoResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(todoResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<Todo> putById(@PathVariable Long id, TodoRequest request) {
        Todo todo = todoService.putById(id, request);
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> DeleteById(@PathVariable Long id) {
        todoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

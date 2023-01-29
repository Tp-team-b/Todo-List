package com.example.TodoList.dto;

import com.example.TodoList.entitiy.Todo;
import lombok.*;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequest {

    private String todo;
    private Boolean completed;

    public TodoRequest(Todo todo) {
        this.todo = todo.getTodo();
        this.completed = todo.getComplete();
    }
}

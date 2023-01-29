package com.example.TodoList.dto;

import com.example.TodoList.entitiy.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TodoResponse {

    private Long id;
    private String todo;
    private Boolean completed;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.todo = todo.getTodo();
        this.completed = todo.getComplete();
    }
}

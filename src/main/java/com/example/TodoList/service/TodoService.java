package com.example.TodoList.service;

import com.example.TodoList.dto.TodoRequest;
import com.example.TodoList.entitiy.Todo;
import com.example.TodoList.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    TodoRepository todoRepository;

    public Todo create(TodoRequest request) {
        // 할 일 추가
        Todo todo = new Todo();
        todo.setTodo(request.getTodo());
        todo.setComplete(false);
        return todoRepository.save(todo);
    }

    public List<Todo> findAll() {
        // 전체 리스트 조회
        return todoRepository.findAll();
    }

    public Todo findById(Long id) {
        // 특정 아이템 조회
        return todoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Todo putById(Long id, TodoRequest request) {
        // 특정 아이템 수정
        Todo todo = this.findById(id);
        if(request.getTodo() != null) {
            todo.setTodo(request.getTodo());
        }
        if(request.getCompleted() != null) {
            todo.setComplete(request.getCompleted());
        }
        return todoRepository.save(todo);
    }

    public void deleteById(Long id) {
        // 특정 아이템 삭제
        todoRepository.deleteById(id);
    }
}

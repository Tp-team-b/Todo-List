package com.example.board.controller;

import com.example.board.dto.TodoDto;
import com.example.board.entity.Member;
import com.example.board.entity.Todo;
import com.example.board.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoRepository todoRepository;

    @ResponseBody
    @PostMapping("/add-todo")
    public Todo addTodoList(@RequestBody TodoDto todoDto) {
        Todo todo = new Todo();
        todo.setContent(todoDto.getContent());
        todo.setDone(false);
        todo.setDueDate(todoDto.getDueDate());

        Todo savedTodo = todoRepository.save(todo);

        return savedTodo;
    }

    @ResponseBody
    @GetMapping("/todo")
    public String getTodoList(@RequestParam Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        log.info("id={}, todo={}",id,todo);
        if(todo.isPresent()) {
            return todo.get().toString();
        } else {
            return "id wrong";
        }
    }

    @ResponseBody
    @GetMapping("/check-todo")
    public String checkTodoList(@RequestParam Long id) {
        Optional<Todo> todo = todoRepository.findById(id);

        if(todo.isPresent()) {
            Todo t = todo.get();
            t.setDone(true);
            Todo save = todoRepository.save(t);
            return save.toString();
        } else {
            return "id wrong";
        }
    }

    @ResponseBody
    @GetMapping("/get-unchecked-todo")
    public Optional<Todo> getUncheckedTodo() {
        Optional<Todo> todo = todoRepository.findByIsDone(false);
        return todo;
    }

    @ResponseBody
    @GetMapping("/get-all-todo")
    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }
}

package com.example.todolisttest.controller;

import com.example.todolisttest.dto.TodoCreateDto;
import com.example.todolisttest.dto.TodoUpdateDto;
import com.example.todolisttest.entity.Todo;
import com.example.todolisttest.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/items")
    public ResponseEntity<Todo> addTodo(@Valid @RequestBody TodoCreateDto todoCreateDto) {
        Todo newTodo = todoService.addTodo(todoCreateDto);
        return ResponseEntity.ok(newTodo);
    }

    @GetMapping("/items")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Todo> updateTodoName(@PathVariable Long id, @Valid @RequestBody TodoUpdateDto todoUpdateDto) {
        todoUpdateDto.setId(id);
        Todo updatedTodo = todoService.updateTodoName(todoUpdateDto);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<HttpStatus> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/items/complete/{id}")
    public ResponseEntity<Todo> toggleTodoCompleted(@PathVariable Long id) {
        Todo updatedTodo = todoService.updateTodoCompleted(id);
        return ResponseEntity.ok(updatedTodo);
    }

    @PutMapping("/items/check/{id}")
    public ResponseEntity<Todo> toggleTodoChecked(@PathVariable Long id) {
        Todo updatedTodo = todoService.updateTodoChecked(id);
        return ResponseEntity.ok(updatedTodo);
    }
}

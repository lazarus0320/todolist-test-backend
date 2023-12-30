package com.example.todolisttest.service;

import com.example.todolisttest.dto.TodoCreateDto;
import com.example.todolisttest.dto.TodoUpdateDto;
import com.example.todolisttest.entity.Todo;
import com.example.todolisttest.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo addTodo(TodoCreateDto todoCreateDto) {
        Todo todo = new Todo();
        todo.setTitle(todoCreateDto.getTitle());
        todo.setCompleted(false);
        todo.setChecked(false);

        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Todo updateTodoName(TodoUpdateDto todoUpdateDto) {
        Todo todo = todoRepository.findById(todoUpdateDto.getId())
                .orElseThrow(() -> new NoSuchElementException("할일 목록을 찾지 못했습니다."));

        todo.setTitle(todoUpdateDto.getTitle());
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("할일 목록을 찾지 못했습니다."));

        todoRepository.delete(todo);
    }

    public Todo updateTodoCompleted(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("할일 목록을 찾지 못했습니다."));
        todo.setCompleted(!todo.isCompleted());
        return todoRepository.save(todo);
    }

    public Todo updateTodoChecked(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("할일 목록을 찾지 못했습니다."));
        todo.setChecked(!todo.isChecked());
        return todoRepository.save(todo);
    }
}

package dev.bank.bankstatement.web.controller;

import dev.bank.bankstatement.core.todo.application.TodoService;
import dev.bank.bankstatement.core.todo.domain.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/todos")
@CrossOrigin("*")
public class TodoRestController {

    TodoService todoService;

    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * 전체 Todo 데이터 조회 메서드 findAll()
     *
     * 모든 메서드의 반환 타입은 List<Todo>
     */
    @GetMapping
    public List<Todo> findAll() {
        log.info("로그");
        return todoService.findAll();
    }

    // Post - save()
    @PostMapping
    public List<Todo> save(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    //Put - update()
    @PutMapping
    public List<Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);
    }

    // Delete - delete()
    @DeleteMapping
    public List<Todo> delete(@RequestParam Long id) {
        return todoService.delete(id);
    }
}

package dev.bank.bankstatement.core.todo.application;

import dev.bank.bankstatement.core.todo.domain.Todo;
import dev.bank.bankstatement.core.todo.infrastructure.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public List<Todo> save(Todo todo) {
        todoRepository.save(todo);
        return findAll();
    }

    public List<Todo> update(Todo todo) {
        todoRepository.save(todo);

        return findAll();
    }


    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);

        return findAll();
    }
}

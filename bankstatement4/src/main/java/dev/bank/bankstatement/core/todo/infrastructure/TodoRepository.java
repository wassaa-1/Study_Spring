package dev.bank.bankstatement.core.todo.infrastructure;

import dev.bank.bankstatement.core.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

// SimpleJpaRepository ? JpaRepository 의 구현체
// SimpleJpaRepository 내부에 @Repository 가 이미 작성되어 있기 때문에
// TodoRepository 에 별도로 작성하지 않아도, 빈으로 등록됨
public interface TodoRepository extends JpaRepository<Todo, Long> {

}

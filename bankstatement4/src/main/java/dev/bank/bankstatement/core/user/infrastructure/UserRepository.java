package dev.bank.bankstatement.core.user.infrastructure;

import dev.bank.bankstatement.core.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
    // 형식에 맞게 필드명을 넣어 메서드명을 만들면 자동으로 만들어 줌 
    // 원래 findByPassword는 JpaRepository에 없지만 findById와 같은 형식으로 이름을 지었기 떄문에 자동으로 생성됨
    Optional<User> findByPassword(String password);
}

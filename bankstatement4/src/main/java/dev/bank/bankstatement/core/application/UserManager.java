package dev.bank.bankstatement.core.application;

import dev.bank.bankstatement.core.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * UserFinder 인터페이스 구현체(구현 클래스)
 *
 * 전통적인 인터페이스, 구현 클래스 네이밍 방식
 * 인터페이스명: UserService.java
 * 구현클래스명: UserServiceImpl.java or IUserService.java
 */
@Service
public class UserManager implements UserFinder, UserEditor {

    @Override
    public List<User> findAll() {
        // Dummy Data 테스트, DB 사용 전 코드
        User user1 = new User("qqqwww", "1234");
        User user2 = new User("efsd", "5678");
        List<User> users = new ArrayList<>(Arrays.asList(user1, user2));

        // user가 한명도 없을 경우, null 대신 비어있는 리스트 반환
        if (users.isEmpty()) return Collections.emptyList();

        return users;
    }

    @Override
    public User findUser(String id) {
        String message = String.format("%s에 해당하는 User가 없습니다.", id);


//        if (id == null) {
//            throw NoSuchElementException(message);
//        }
        // TODO: 추후 DB layer 구현 시 작성 예정

        User u = new User(id, "1234");
        return u;
    }

    @Override
    public String create(User newUser) {
        // TODO: 추후 DB layer 구현 시 작성 예정
        return newUser.getId();
    }
}

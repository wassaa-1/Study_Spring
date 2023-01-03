package dev.bank.bankstatement.core.application;

import dev.bank.bankstatement.core.domain.User;
import dev.bank.bankstatement.core.infrastructure.UserRepository;
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

    private UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        // Dummy Data 테스트, DB 사용 전 코드
//        User user1 = new User("qqqwww", "1234");
//        User user2 = new User("efsd", "5678");
//        List<User> users = new ArrayList<>(Arrays.asList(user1, user2));
//
//        // user가 한명도 없을 경우, null 대신 비어있는 리스트 반환
//        if (users.isEmpty()) return Collections.emptyList();

        return userRepository.findAll();
    }

    @Override
    public User findUser(String id) {
//        String message = String.format("%s에 해당하는 User가 없습니다.", id);

//        if (id == null) {
//            throw NoSuchElementException(message);
//        }
        String message = String.format("%s에 해당하는 User가 없습니다.", id);
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException(message));
        return user;
    }

    @Override
    public User findByPassword(String password) {
        String message = String.format("%s에 해당하는 User가 없습니다.", password);
        User user = userRepository.findByPassword(password).orElseThrow(() -> new NoSuchElementException(message));
        return user;
    }

    @Override
    public String create(User newUser) {
        if(userRepository.findById(newUser.getId()).isPresent()) {
            String message = String.format("이미 존재하는 user id입니다. %s", newUser.getId());
            throw new IllegalArgumentException(message);
        }

        userRepository.save(newUser);

        return newUser.getId();
    }

    @Override
    public User update(User updateUser) {
        final Optional<User> user = userRepository.findById(updateUser.getId());
        if (user.isPresent()) {
            final User foundUser = user.get();
            foundUser.setPassword(updateUser.getPassword());
            userRepository.save(foundUser);
        }
        User updatedUser = userRepository.findById(updateUser.getId()).get();
        return updatedUser;
    }

    @Override
    public String delete(String id) {
        final Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            final User deleteUser = user.get();
            userRepository.delete(deleteUser);
        }
        return id;
    }
}

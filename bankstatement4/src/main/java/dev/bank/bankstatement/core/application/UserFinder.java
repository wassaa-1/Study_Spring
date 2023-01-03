package dev.bank.bankstatement.core.application;

import dev.bank.bankstatement.core.domain.User;

import java.util.List;

/**
 * 사용자(User) 검색기
 */
public interface UserFinder {

    /**
     * DB에 등록된 모든 User 리스트 반환
     * 하나도 없을 경우 비어있는 리스트 반환
     * @return List<User>
     */
    List<User> findAll();

    /**
     * 전달된 id와 일치하는 하나의 User 반환
     * @param id
     * @return User
     * @throws java.util.NoSuchElementException - User의 id가 유효하지 않을 때
     */
    User findUser(String id);

    /**
     * 전달된 password와 일치하는 하나의 User 반환
     * @param password
     * @return User
     */
    User findByPassword(String password);
}

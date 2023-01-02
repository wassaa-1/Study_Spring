package dev.bank.bankstatement.core.application;

import dev.bank.bankstatement.core.domain.User;

/**
 * User 정보 편집기
 * (create, update, delete 등)
 */
public interface UserEditor {

    /**
     * 새로운 User 등록
     * @param newUser - 새로 등록된 User Entity
     * @return String id - 가입된 user id
     */
    String create(User newUser);
}
